package org.sepherd.shea.ghostnet.service

import org.sepherd.shea.ghostnet.Status
import org.sepherd.shea.ghostnet.db.GhostNet
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
}