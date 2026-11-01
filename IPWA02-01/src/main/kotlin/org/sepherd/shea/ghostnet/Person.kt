package org.sepherd.shea.ghostnet

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

/**
 * Personeninformationen für meldende und bergende Personen.
 *
 * Beide Arten von Personen sind natürliche Personen mit einem Namen und einer Telefonnummer für Rückfragen.
 */
@Entity
@Table(name = "person")
data class Person(
    val name: String,
    val phoneNumber: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
