package daljin.spring.study

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/coffee")
class CoffeeController(private val coffeeRepository: CoffeeRepository) {

    @GetMapping
    fun getCoffeeList(): Flux<Coffee> {
        return coffeeRepository.findAll()
    }

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String): Mono<Coffee> {
        return coffeeRepository.findById(id)
    }

    @PostMapping
    fun postCoffee(@RequestBody coffee: Coffee): Mono<Coffee> {
        return coffeeRepository.save(coffee)
    }

    @PutMapping("/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee): Mono<Coffee> {
        return coffeeRepository.save(coffee)

    }

    @DeleteMapping("/{id}")
    fun deleteCoffee(@PathVariable id: String): Unit {
        coffeeRepository.deleteById(id)
    }
}