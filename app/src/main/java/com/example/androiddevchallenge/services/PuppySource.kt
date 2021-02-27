package com.example.androiddevchallenge.services

data class Pupper(
    val name: String,
    val age: String,
    val gender: String,
    val breed: String,
    val photo: String,
    val description: String = ""
)

class PuppySource {
    companion object {
        fun GeneratePuppy(): Pupper {
            return Pupper("Frank", "3", "Male", "Pug", "A picture")
        }
    }
    fun getThePuppies(): List<Pupper> {
        return listOf(
            Pupper("Frank", "3", "Male", "Pug", "A picture"),
            Pupper("Frank", "3", "Male", "Pug", "A picture"),
            Pupper("Frank", "3", "Male", "Pug", "A picture")
        )
    }
}