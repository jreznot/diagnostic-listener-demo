package org.example

import com.intellij.openapi.diagnostic.*

private val LOG = logger<DiagnosticLoggerErrorReportSink>()

@Suppress("UnstableApiUsage")
internal class DiagnosticLoggerErrorReportSink : ErrorReportSink {
    override suspend fun submit(report: UnhandledErrorReport) {
        when (report) {
            is UnhandledExceptionReport -> LOG.warn("Unhandled exception in plugin" + report.exceptionClass)
            is UnhandledFreezeReport -> LOG.warn("UI freeze detected in plugin: ${report.durationMs}ms")
        }
    }
}
