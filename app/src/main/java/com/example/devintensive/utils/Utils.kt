package com.example.devintensive.utils

import java.util.*

object Utils {

    //Function divide a string with full name in two strings - first name and last name
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        //Function checks the name. If it contains empty string, it returns null.
        if (lastName != null && firstName != null) {
            when {
                firstName.contains(" ", true) ->
                    firstName = null
                fullName == "" || firstName == "" -> {
                    firstName = null
                    lastName = null
                }
                lastName == "" && firstName != "" -> lastName = null
                lastName.contains(" ", true)
                ->
                    lastName = null

            }
        } else if (fullName == "") {
            firstName = null
            lastName = null
        }

        println("First name = $firstName, last name = $lastName")
        return Pair(firstName, lastName)
    }

    //Returns russian name in english letters
    fun transliteration(payload: String, divider: String = "_"): String {
        return payload.replace(Regex("[абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ ]")) {
            when (it.value) {
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "e"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh'"
                "ъ" -> ""
                "Ъ" -> ""
                "ы" -> "I"
                "Ы" -> "I"
                "ь" -> ""
                "Ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                "А" -> "A"
                "Б" -> "B"
                "В" -> "V"
                "Г" -> "G"
                "Д" -> "D"
                "Е" -> "E"
                "Ё" -> "E"
                "Ж" -> "Zh"
                "З" -> "Z"
                "И" -> "I"
                "Й" -> "I"
                "К" -> "K"
                "Л" -> "L"
                "М" -> "M"
                "Н" -> "N"
                "О" -> "O"
                "П" -> "P"
                "Р" -> "R"
                "С" -> "S"
                "Т" -> "T"
                "У" -> "U"
                "Ф" -> "F"
                "Х" -> "H"
                "Ц" -> "C"
                "Ч" -> "Ch"
                "Ш" -> "Sh"
                "Щ" -> "Sh'"
                "Э" -> "E"
                "Ю" -> "Yh"
                "Я" -> "Yh"
                " " -> divider
                else -> it.value
            }
        }

    }

    //Return initials of a full name
    fun toInitials(firstName: String?, lastName: String?): String? {
        
        return ("${firstName?.toUpperCase()?.get(0)}${lastName?.toUpperCase()?.get(0)}")
    }





}