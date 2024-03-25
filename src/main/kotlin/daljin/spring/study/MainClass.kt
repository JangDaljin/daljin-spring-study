package daljin.spring.study

import org.springframework.boot.runApplication

class MainClass {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<StudyApplication>(*args)
        }
    }
}