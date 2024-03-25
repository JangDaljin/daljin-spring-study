package daljin.spring.study

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Coffee {
    @Id
    val id: String
    val name: String

    constructor(id: String, name: String) {
        this.id = id
        this.name = name
    }

    constructor(name: String) : this(UUID.randomUUID().toString(), name)
}