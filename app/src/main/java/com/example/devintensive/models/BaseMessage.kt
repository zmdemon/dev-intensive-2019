package com.example.devintensive.models

import android.provider.ContactsContract
import java.util.*
import kotlin.reflect.typeOf

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()

) {
    abstract fun formatMessage():String
    fun fakeFormatMessage(
        id: String,
        from: User?,
        chat: Chat,
        isIncoming: Boolean,
        date: Date
    ): String {

        return ("${from?.firstName} ${if (isIncoming) "отправил" else "получил"} сообщение '$chat' $date")
    }

    companion object AbstractFactory {
        var lastId: Int = -1
        fun makeMessage(
            from: User?,
            chat: Chat,
            date: Date = Date(),
            type: String = "text",
            payload: Any
        ): BaseMessage {
            lastId++
            return when (type) {
                "image" -> ImageMessage(
                    "$lastId",
                    from,
                    chat,
                    date = date,
                    image = payload as String
                )
                else -> TextMessage("$lastId", from, chat, date = date, text = payload as String)
            }
        }
    }

}