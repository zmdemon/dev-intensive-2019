package com.example.devintensive.models

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.devintensive.utils.Utils
import java.util.*

class User (
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    var lastVisit:Date? = null,
    var isOnline:Boolean = false
    ) {
    constructor(id:String, firstName: String?, lastName: String?): this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )
    constructor(id: String): this(id, "Joe", "Doe")
    init {
        println("bomb has been planted")
        // Print first name and last name of the user
    }

    companion object Factory{
        private var lastid : Int = -1
        fun makeUser(fullName:String?):User{
            lastid++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastid", firstName = firstName, lastName = lastName )
        }
    }

}

// Compare code below
// class UserFactory(
//    private val user: User,
//    private val application: Application
//) : ViewModelProvider.Factory {
//    @Suppress("unchecked_cast")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(SleepTrackerViewModel::class.java)) {
//            return SleepTrackerViewModel(dataSource, application) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}