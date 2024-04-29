package daljin.spring.study

import daljin.spring.study.response.RestResponseDto
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.)
@AutoConfigureWebTestClient
class CoffeeControllerTest {

    @BeforeEach
    fun setUp() {

    }

    @AfterEach
    fun tearDown() {

    }

    @Test
    fun getCoffeeList(@Autowired client: WebTestClient) {
        assert(
            client.get()
                .uri("/coffee")
                .exchange()
                .expectStatus().isOk()
                .expectBody(RestResponseDto::class.java)
                .returnResult()
                .responseBody?.toString()?.isNotEmpty() ?: false
        )
    }

}