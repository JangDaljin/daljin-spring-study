package daljin.spring.study

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class H2R2dbcConfig {
    @Bean
    fun init(coffeeRepository: CoffeeRepository): CommandLineRunner {
        return CommandLineRunner {
            coffeeRepository.saveAll(
                listOf(
                    Coffee("Espresso"),
                    Coffee("Cafe Latte")
                )
            ).thenMany(coffeeRepository.findAll())
                .subscribe(System.out::println)
        }
    }
}