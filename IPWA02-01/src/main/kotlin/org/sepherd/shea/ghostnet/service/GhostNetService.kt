package org.sepherd.shea.ghostnet.service

import jakarta.transaction.Transactional
import org.sepherd.shea.ghostnet.Status
import org.sepherd.shea.ghostnet.db.GhostNet
import org.sepherd.shea.ghostnet.db.Person
import org.sepherd.shea.ghostnet.repository.GhostNetRepository
import org.sepherd.shea.ghostnet.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class GhostNetService(
    private val ghostNetRepository: GhostNetRepository,
    private val personRepository: PersonRepository
) {

    fun getAllGhostNets(): List<GhostNet> {
        return ghostNetRepository.findAll()
    }

    fun getActiveGhostNets(): List<GhostNet> {
        return ghostNetRepository.findByStatusIn(
            listOf(Status.GEMELDET, Status.BERGUNG_BEVORSTEHEND)
        )
    }

    fun getGhostNetById(id: Long): GhostNet {
        return ghostNetRepository.findById(id).orElseThrow { IllegalArgumentException("Geisternetz mit ID: $id nicht gefunden") }
    }

    @Transactional
    fun reportGhostNet(
        latitude: Double,
        longitude: Double,
        estimatedSize: Int,
        reporterName: String?,
        reporterPhone: String?
    ): GhostNet {
        val reporter = if (!reporterName.isNullOrBlank() && !reporterPhone.isNullOrBlank()) {
            Person(name = reporterName, phoneNumber = reporterPhone)
        } else null

        val net = GhostNet(
            latitude = latitude,
            longitude = longitude,
            estimatedSize = estimatedSize,
            status = Status.GEMELDET,
            reporter = reporter
        )
        return ghostNetRepository.save(net)
    }

    @Transactional
    fun assignRescuer(netId: Long, rescuerName: String, rescuerPhone: String): GhostNet {
        require(rescuerName.isNotBlank()) { "Bergende Person muss einen Namen haben" }
        require(rescuerPhone.isNotBlank()) { "Bergende Person muss eine Telefonnummer haben" }

        val net = getGhostNetById(netId)
        check(net.status == Status.GEMELDET) { "Netz ist bereits für Bergung eingetragen oder geborgen" }

        val rescuer = Person(name = rescuerName, phoneNumber = rescuerPhone)
        val updatedNet = net.copy(rescuer = rescuer, status = Status.BERGUNG_BEVORSTEHEND)

        return ghostNetRepository.save(updatedNet)
    }

    @Transactional
    fun markAsRescued(netId: Long): GhostNet {
        val net = getGhostNetById(netId)
        check(net.status == Status.BERGUNG_BEVORSTEHEND) { "Nur Netze mit Status \"Bergung bevorstehend\" können als geborgen gemeldet werden" }

        val updatedNet = net.copy(status = Status.GEBORGEN)
        return ghostNetRepository.save(updatedNet)
    }

    @Transactional
    fun markAsMissing(netId: Long, personName: String, personPhone: String): GhostNet {
        require(personName.isNotBlank() && personPhone.isNotBlank()) { "Geisternetze können nicht anonym als verschollen gemeldet werden" }

        val net = getGhostNetById(netId)
        val person = Person(name = personName, phoneNumber = personPhone)
        val updatedNet = net.copy(status = Status.VERSCHOLLEN, reporter = person)
        return ghostNetRepository.save(updatedNet)
    }
}