package daljin.spring.study

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/droid")
class DroidController(private val droid: Droid) {

    @GetMapping
    fun getDroid(): Droid {
        return droid
    }
}