package daljin.spring.study

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer

@SpringBootApplication
class SburRedisApplication {

    companion object {
        fun main(args: Array<String>) {
            runApplication<StudyApplication>(*args)
        }
    }


    @Bean
    fun redisOperations(factory: RedisConnectionFactory): RedisOperations<String, Aircraft> {
        return RedisTemplate<String, Aircraft>().apply {
            this.connectionFactory = factory
            this.setDefaultSerializer(Jackson2JsonRedisSerializer(Aircraft::class.java))
            this.keySerializer = StringRedisSerializer()
        }
    }


}