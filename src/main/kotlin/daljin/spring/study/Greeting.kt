package daljin.spring.study

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "greeting")
class Greeting {
    lateinit var name: String
    lateinit var coffee: String
}