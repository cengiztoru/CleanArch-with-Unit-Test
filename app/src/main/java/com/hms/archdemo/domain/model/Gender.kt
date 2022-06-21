package com.hms.archdemo.domain.model

sealed class Gender {
    object Male : Gender()
    object Female : Gender()
}