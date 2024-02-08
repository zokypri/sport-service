package se.implementer.sportservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SportServiceApplication

fun main(args: Array<String>) {
	runApplication<SportServiceApplication>(*args)
}
