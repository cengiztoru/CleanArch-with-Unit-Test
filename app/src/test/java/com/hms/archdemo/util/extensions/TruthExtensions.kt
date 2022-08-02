package com.hms.archdemo.util.extensions

import com.google.common.truth.Truth.assertThat

infix fun Any?.shouldEqual(expected: Any?) {
    assertThat(this).isEqualTo(expected)
}
