package daljin.spring.study

import org.springframework.data.r2dbc.repository.R2dbcRepository

interface CoffeeRepository : R2dbcRepository<Coffee, String>