package com.example.devintensive.extensions

import com.example.devintensive.models.User
import com.example.devintensive.models.UserView
import com.example.devintensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView {

    val nickname = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "Еще ни разу не заходил" else if (isOnline) "В сети" else "Последний раз был ${lastVisit?.humanizeDiff()}"
    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickname = nickname,
        initials = initials,
        avatar = avatar,
        status = status
    )
}






