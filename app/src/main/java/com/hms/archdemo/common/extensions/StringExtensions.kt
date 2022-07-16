package com.hms.archdemo.common.extensions

import java.util.*

fun String.capitalizeFirstChar(): String {
    return replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}