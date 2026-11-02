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
}