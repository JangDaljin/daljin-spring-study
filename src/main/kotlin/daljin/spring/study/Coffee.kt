package daljin.spring.study

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*

@Entity
data class Coffee(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String,
    val name: String
) {
    constructor(name: String) : this(UUID.randomUUID().toString(), name)
}