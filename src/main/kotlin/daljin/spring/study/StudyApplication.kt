package daljin.spring.study

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@ConfigurationPropertiesScan
class StudyApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<StudyApplication>(*args)
        }
    }
    
}

