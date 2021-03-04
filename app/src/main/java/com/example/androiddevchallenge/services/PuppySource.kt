/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        private val names: List<String> = listOf("Frank", "Todd", "Ed", "Joe", "Jeff")
        private val nameEnds = listOf("ington", "ward", "bert", "ley")
        private val ages: List<String> = listOf("1", "2", "3", "4", "5")
        private val breeds = listOf("Pug", "Retriever", "Dachshund")
        private val descriptions = listOf("He's extremely friendly", "He barks loudly at all hours of the day", "He loves people, but sleeps a lot")

        fun GeneratePuppy(): Pupper {
            return Pupper(
                name = makeName(),
                age = makeAge(),
                gender = "male",
                breed = makeBreed(),
                photo = "A picture",
                description = makeDescription()
            )
        }

        private fun makeName(): String {
            return names.random() + nameEnds.random()
        }

        private fun makeAge(): String {
            return ages.random()
        }

        private fun makeBreed(): String {
            return breeds.random()
        }

        private fun makeDescription(): String {
            return descriptions.random()
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
