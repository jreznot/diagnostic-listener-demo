package org.example

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

internal class AlwaysThrowExceptionAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        throw RuntimeException("Test exception from Diagnostic Logger Demo plugin")
    }
}
