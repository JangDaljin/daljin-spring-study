package daljin.spring.study

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    private val passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    @Bean
    fun authentication(): UserDetailsService {
        val daljin =
            User.builder().username("daljin").password(passwordEncoder.encode("ppppaaassswwworrrddd")).roles("USER")
                .build()
        val daljin2 =
            User.builder().username("daljin2").password(passwordEncoder.encode("this is password"))
                .roles("USER", "ADMIN")
                .build()

        println(">>> daljin's password ${daljin.password}")
        println(">>> daljin2's password ${daljin2.password}")

        return InMemoryUserDetailsManager(
            daljin, daljin2
        )
    }

    @Bean
    @Throws(Exception::class)
    fun configure(http: HttpSecurity): SecurityFilterChain {
        return http.authorizeHttpRequests {
            it.requestMatchers("/coffee/**").hasRole("ADMIN")
                .anyRequest().authenticated()
        }.formLogin {

        }.httpBasic {
        }
            .build()
    }
}