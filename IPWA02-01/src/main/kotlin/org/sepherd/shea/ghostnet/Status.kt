package org.sepherd.shea.ghostnet

/**
 * Geisternetz Status laut Dokumentation
 *
 * * Gemeldet (Eine meldende Person hat das Geisternetz im System erfasst.)
 * * Bergung bevorstehend (Eine bergende Person hat die Bergung angekündigt.)
 * * Geborgen (Eine bergende Person hat das Geisternetz erfolgreich geborgen.)
 * * Verschollen (Eine beliebige Person hat festgestellt, dass das Geisternetz am gemeldeten Standort nichtauffindbar ist.)
 */
enum class Status {
    GEMELDET,
    BERGUNG_BEVORSTEHEND,
    GEBORGEN,
    VERSCHOLLEN
}