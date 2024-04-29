package daljin.spring.study

import org.springframework.data.repository.CrudRepository


interface CoffeeRepository : CrudRepository<Coffee, String>