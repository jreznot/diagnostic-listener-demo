# Diagnostic-logger-plugin

[![Twitter Follow](https://img.shields.io/badge/follow-%40JBPlatform-1DA1F2?logo=twitter)](https://twitter.com/JBPlatform)
[![Developers Forum](https://img.shields.io/badge/JetBrains%20Platform-Join-blue)](https://platform.jetbrains.com/)

## Demo

This plugin demonstrates the `ErrorReportSink` extension point, which allows IDE plugins to observe unhandled exceptions
and UI freezes attributed to their own code.

### ErrorReportSink

`DiagnosticLoggerErrorReportSink` implements `ErrorReportSink` and logs a `WARN`-level message whenever the IDE reports
an unhandled exception or a UI freeze caused by this plugin.

- For exceptions: logs the exception with its stack trace.
- For freezes: logs the freeze duration in milliseconds.

To trigger the sink, use the two demo actions below (find them via **Help | Find Action** or the Search Everywhere
dialog):

| Action                     | Description                                                                      |
|----------------------------|----------------------------------------------------------------------------------|
| **Always Throw Exception** | Throws a `RuntimeException` on the EDT, producing an unhandled-exception report. |
| **Always Freeze**          | Calls `Thread.sleep(20 000)` on the EDT, producing a UI-freeze report.           |

After running either action, check the IDE log (`Help | Show Log in Finder/Explorer`) for `WARN`
entries from `DiagnosticLoggerErrorReportSink`.

**Note!** Please run plugin without debug to see it in action, otherwise freeze detector is disabled.

Example output:

> 2026-05-26 21:26:04,391 [35580069]   WARN - #org.example.DiagnosticLoggerErrorReportSink - UI freeze detected in plugin: 30002ms

> 2026-05-26 21:26:42,221 [35617899]   WARN - #org.example.DiagnosticLoggerErrorReportSink - Unhandled exception in pluginclass java.lang.RuntimeException