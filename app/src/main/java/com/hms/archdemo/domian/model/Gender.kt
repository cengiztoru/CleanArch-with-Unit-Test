package com.hms.archdemo.domian.model

sealed class Gender {
    object Male : Gender()
    object Female : Gender()
}