package org.sepherd.shea.ghostnet.db

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.sepherd.shea.ghostnet.Status

/**
 * ## Informationen zu Geisternetzen
 *
 * * Standort (GPS-Koordinaten)
 * * geschätzte Größe
 * * Status
 *
 * ## Personenrelationen:
 * * Meldende Personen können anonym bleiben
 * * Geisternetze können immer nur maximal einer bergenden Person zugeordnet werden
 * * Bergende Personen können allerdings mehr als ein Geisternetz gleichzeitig bergen
 */
@Entity
@Table(name = "ghost_net")
data class GhostNet(
    val latitude: Double,
    val longitude: Double,
    val estimatedSize: Double,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @Enumerated(EnumType.STRING) val status: Status = Status.GEMELDET,
    @ManyToOne(cascade = [CascadeType.ALL]) @JoinColumn(name = "reporter_id") val reporter: Person? = null,
    @ManyToOne(cascade = [CascadeType.ALL]) @JoinColumn(name = "rescuer_id") val rescuer: Person? = null,
)
