package org.sepherd.shea.ghostnet.controller

import org.sepherd.shea.ghostnet.Status
import org.sepherd.shea.ghostnet.service.GhostNetService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/assign")
class AssignNetController(
    private val ghostNetService: GhostNetService
) {

    @GetMapping("/{id}")
    fun showAssignForm(@PathVariable id: Long, model: Model): String {
        val net = ghostNetService.getGhostNetById(id)
        if (net.status != Status.GEMELDET) {
            return "redirect:/"
        }

        model.addAttribute("net", net)
        return "assign"
    }

    @PostMapping("/{id}")
    fun processAssign(
        @PathVariable id: Long,
        @RequestParam rescuerName: String,
        @RequestParam rescuerPhone: String
    ): String {
        ghostNetService.assignRescuer(id, rescuerName, rescuerPhone)
        return "redirect:/"
    }
}