package org.example

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.application.runReadActionBlocking

internal class AlwaysFreezeAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        runReadActionBlocking {
            Thread.sleep(30_000)
        }
    }
}
