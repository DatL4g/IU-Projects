package org.sepherd.shea.ghostnet.repository

import org.sepherd.shea.ghostnet.Status
import org.sepherd.shea.ghostnet.db.GhostNet
import org.springframework.data.jpa.repository.JpaRepository

interface GhostNetRepository : JpaRepository<GhostNet, Long> {
    fun findByStatusIn(status: List<Status>): List<GhostNet>
}