package org.sepherd.shea.ghostnet.controller

import org.sepherd.shea.ghostnet.service.GhostNetService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/report")
class ReportNetController(
    private val ghostNetService: GhostNetService
) {

    @GetMapping
    fun showReportForm(model: Model): String {
        return "report"
    }

    @PostMapping
    fun processReport(
        @RequestParam latitude: Double,
        @RequestParam longitude: Double,
        @RequestParam estimatedSize: Int,
        @RequestParam(required = false) reporterName: String?,
        @RequestParam(required = false) reporterPhone: String?
    ): String {
        ghostNetService.reportGhostNet(latitude, longitude, estimatedSize, reporterName, reporterPhone)
        return "redirect:/"
    }
}