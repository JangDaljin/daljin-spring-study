package daljin.spring.study

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Bean

@SpringBootApplication
@ConfigurationPropertiesScan
class StudyApplication {

    @Bean
    @ConfigurationProperties(prefix = "droid")
    fun createDroid(): Droid {
        return Droid()
    }
}

