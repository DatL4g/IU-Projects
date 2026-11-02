package org.sepherd.shea.ghostnet.controller

import org.sepherd.shea.ghostnet.service.GhostNetService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class GhostNetController(
    private val ghostNetService: GhostNetService
) {

    @GetMapping
    fun index(model: Model): String {
        model.addAttribute("nets", ghostNetService.getActiveGhostNets())
        return "index"
    }

    @GetMapping("/report")
    fun showReportForm(): String {
        return "report"
    }


}