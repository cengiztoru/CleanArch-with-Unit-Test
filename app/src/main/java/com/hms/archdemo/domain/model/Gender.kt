package com.hms.archdemo.domain.model

enum class Gender(val value: String) {
    MALE("male"),
    FEMALE("female"),
    OTHER("other");

    companion object {
        fun from(value: String): Gender = values().find { it.value == value } ?: OTHER
    }
}
