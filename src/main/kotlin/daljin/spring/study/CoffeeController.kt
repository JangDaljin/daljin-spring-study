package daljin.spring.study

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coffee")
class CoffeeController(private val coffeeRepository: CoffeeRepository) {

    init {
        coffeeRepository.saveAll(
                listOf(
                        Coffee("Coffee1"),
                        Coffee("Coffee2"),
                        Coffee("Coffee3"),
                        Coffee("Coffee4")
                )
        )
    }

    @GetMapping
    fun getCoffeeList(): ResponseEntity<List<Coffee>> {
        return ResponseEntity(coffeeRepository.findAll().toList(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String): ResponseEntity<Coffee> {
        return ResponseEntity(coffeeRepository.findById(id).orElseThrow(), HttpStatus.OK)
    }

    @PostMapping
    fun postCoffee(@RequestBody coffee: Coffee): ResponseEntity<Coffee> {
        return ResponseEntity(coffeeRepository.save(coffee), HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee): ResponseEntity<Coffee> {
        return ResponseEntity(coffeeRepository.save(coffee), if (coffeeRepository.existsById(id))
            HttpStatus.OK
        else
            HttpStatus.CREATED
        )
    }

    @DeleteMapping("/{id}")
    fun deleteCoffee(@PathVariable id: String): Unit {
        coffeeRepository.deleteById(id)
    }
}