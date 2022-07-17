package com.hms.archdemo.util.extensions

import com.google.common.truth.Truth.assertThat

infix fun Any?.shouldBe(expected: Any?) {
    assertThat(this).isEqualTo(expected)
}
