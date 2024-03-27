package daljin.spring.study

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeting")
class GreetingController(
    private val greeting: Greeting
) {

    @GetMapping
    fun getGreeting(): String {
        return this.greeting.name
    }

    @GetMapping("/coffee")
    fun getNameAndCoffee(): String {
        return this.greeting.coffee
    }
}