package com.example.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        //Function check the name if it contains empty string.
        if (lastName != null && firstName != null) {
            when {
                firstName.contains(" ", true) ->
                    firstName = null
                fullName == "" || firstName == "" -> {
                    firstName = null
                    lastName = null
                }
                lastName == "" || firstName != "" -> lastName = null
                lastName.contains(" ", true)
                ->
                    lastName = null

            }
        } else if (fullName == ""){
            firstName = null
            lastName = null
        }

        println("First name = $firstName, last name = $lastName")
        return Pair(firstName, lastName)
    }
}