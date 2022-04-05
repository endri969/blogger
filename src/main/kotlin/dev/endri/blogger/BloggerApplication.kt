package dev.endri.blogger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BloggerApplication

fun main(args: Array<String>) {
	runApplication<BloggerApplication>(*args)
}
