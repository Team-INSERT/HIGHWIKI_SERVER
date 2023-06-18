package wiki.hi.hiwikiserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HiwikiServerApplication

fun main(args: Array<String>) {
	runApplication<HiwikiServerApplication>(*args)
}
