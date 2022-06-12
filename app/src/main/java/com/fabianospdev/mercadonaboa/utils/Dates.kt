package com.fabianospdev.mercadonaboa.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Dates {
    fun stringToDate(): String? {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
        return current.format(formatter)
    }
}