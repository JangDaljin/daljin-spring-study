package daljin.spring.study

import daljin.spring.study.response.RestResponseDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coffee")
class CoffeeController(private val coffeeRepository: CoffeeRepository) {


    @GetMapping
    fun getCoffeeList(): ResponseEntity<RestResponseDto<List<Coffee>>> {
        return ResponseEntity.ok(
            RestResponseDto(
                coffeeRepository.findAll().toList()
            )
        )
    }

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String): ResponseEntity<RestResponseDto<Coffee>> {
        return ResponseEntity.ok(
            RestResponseDto(
                coffeeRepository.findById(id).orElseThrow()
            )
        )
    }

    @PostMapping
    fun postCoffee(@RequestBody coffee: Coffee): ResponseEntity<RestResponseDto<Coffee>> {
        return ResponseEntity.ok(RestResponseDto(coffeeRepository.save(coffee)))
    }

    @PutMapping("/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee): ResponseEntity<RestResponseDto<Coffee>> {
        val beforeCoffee = this.coffeeRepository.findById(id)

        if (beforeCoffee.isEmpty) {
            ResponseEntity.notFound()
        }
        return ResponseEntity.ok(
            RestResponseDto(
                coffeeRepository.save(
                    Coffee(
                        id = id,
                        name = coffee.name
                    )
                )
            )
        )
    }

    @DeleteMapping("/{id}")
    fun deleteCoffee(@PathVariable id: String): Unit {
        coffeeRepository.deleteById(id)
    }
}