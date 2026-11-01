package org.sepherd.shea.ghostnet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GhostnetApplication

fun main(args: Array<String>) {
	runApplication<GhostnetApplication>(*args)
}
