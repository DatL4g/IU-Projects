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
@RequestMapping("/missing")
class MissingNetController(
    private val ghostNetService: GhostNetService
) {

    @GetMapping("/{id}")
    fun showMissingForm(@PathVariable id: Long, model: Model): String {
        val net = ghostNetService.getGhostNetById(id)

        if (net.status == Status.GEBORGEN || net.status == Status.VERSCHOLLEN) {
            return "redirect:/"
        }

        model.addAttribute("net", net)
        return "missing"
    }

    @PostMapping("/{id}")
    fun processMissing(
        @PathVariable id: Long,
        @RequestParam personName: String,
        @RequestParam personPhone: String
    ): String {
        ghostNetService.markAsMissing(id, personName, personPhone)
        return "redirect:/"
    }
}