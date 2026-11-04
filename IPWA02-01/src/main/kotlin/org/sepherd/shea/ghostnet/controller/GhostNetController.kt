package org.sepherd.shea.ghostnet.controller

import org.sepherd.shea.ghostnet.service.GhostNetService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/")
class GhostNetController(
    private val ghostNetService: GhostNetService
) {

    @GetMapping
    fun index(
        @RequestParam(defaultValue = "false") showAll: Boolean,
        model: Model
    ): String {
        val nets = if (showAll) {
            ghostNetService.getAllGhostNets()
        } else {
            ghostNetService.getActiveGhostNets()
        }

        model.addAttribute("nets", nets)
        model.addAttribute("showAll", showAll)
        return "index"
    }

    @GetMapping("/report")
    fun showReportForm(): String {
        return "report"
    }

    @PostMapping("/report")
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

    @PostMapping("/rescued")
    fun markRescued(@RequestParam netId: Long): String {
        ghostNetService.markAsRescued(netId)
        return "redirect:/"
    }

    @PostMapping("/missing")
    fun markAsMissing(
        @RequestParam netId: Long,
        @RequestParam personName: String,
        @RequestParam personPhone: String
    ): String {
        ghostNetService.markAsMissing(netId, personName, personPhone)
        return "redirect:/"
    }

}