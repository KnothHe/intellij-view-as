package com.github.knothhe.intellijviewas.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages

class EditorViewAsAction : AnAction() {
    override fun update(e: AnActionEvent) {
        val project = e.project
        val editor = e.getData(CommonDataKeys.EDITOR)
        e.presentation.isEnabledAndVisible  = project != null && editor != null && editor.selectionModel.hasSelection()
    }

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getRequiredData(CommonDataKeys.PROJECT)
        val editor = e.getRequiredData(CommonDataKeys.EDITOR)

        val selectedText = editor.selectionModel.selectedText
        Messages.showMessageDialog(project, hex2bin(selectedText), "View as", Messages.getInformationIcon())
    }

    private fun hex2bin(s: String?): String {
        if (s == null || s.isEmpty()) {
            return ""
        }

        // get only num character (include 'A' - 'F')
        val onlyNum = getOnlyNumWithUpperCase(s)
        if (!checkHex(onlyNum)) {
            return "Wrong format"
        }

        val num = Integer.parseInt(onlyNum, 16)
        return Integer.toBinaryString(num)
    }

    fun checkHex(s : String) : Boolean {
        // check first char
        val firstChar = s[0]
        if (firstChar !in '1'..'9' && firstChar !in 'A'..'F') {
            return false
        }

        // check remained char
        for ((i, c) in s.withIndex()) {
            if (i == 0) {
                continue
            }
            if (c !in '0'..'9' && c !in 'A'..'F') {
                return false
            }
        }
        return true
    }

    private fun getOnlyNumWithUpperCase(s: String): String {
        val upperCase = s.toUpperCase()

        var start = 0
        if (upperCase.startsWith("0X")) {
            start = 2
        }
        return upperCase.substring(start, upperCase.length)
    }

}