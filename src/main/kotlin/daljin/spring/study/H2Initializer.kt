package daljin.spring.study

import org.springframework.stereotype.Component

@Component
class H2Initializer(private val coffeeRepository: CoffeeRepository) {


    init {
        coffeeRepository.saveAll(
            listOf(
                Coffee("Espresso"),
                Coffee("Latte")
            )
        )
    }

}