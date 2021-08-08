package com.github.knothhe.intellijviewas.action

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class EditorViewAsActionTest {

    @Test
    fun hex2bin() {
    }

    @Test
    fun checkHex() {
        val viewAction = EditorViewAsAction()
        // true
        assertEquals(viewAction.checkHex("0x1234567890ABCDEF"), true)
        assertEquals(viewAction.checkHex("0X1234567890ABCDEF"), true)
        assertEquals(viewAction.checkHex("0X1234567890abcdef"), true)

        // false
        assertEquals(viewAction.checkHex("0123"), false)
    }
}