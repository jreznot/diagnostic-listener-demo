Implement this interface in a plugin to receive reports about unhandled exceptions and UI freezes that occurred in the plugin's code during a user session.

Register the implementation in `plugin.xml`:
```xml
 <extensions defaultExtensionNs="com.intellij">
   <errorReportSink implementation="my.plugin.MyErrorReportSink"/>
 </extensions>
```

```kotlin
/**
 * [submit] is called asynchronously (on a background thread) when an unhandled exception or a UI
 * freeze is attributed to this plugin. Use it to collect metrics or forward reports to a custom
 * backend.
 *
 * **Limitations:**
 * - Bundled IDE plugins are not notified about their errors.
 * - At most 10 000 exception reports per plugin per IDE session are forwarded.
 * - The IDE does not deduplicate or debounce reports; the same exception may be reported many
 *   times if it is thrown repeatedly. Implementations are responsible for deduplication and
 *   rate-limiting on their side.
 *
 * @see UnhandledExceptionReport
 * @see UnhandledFreezeReport
 */
@ApiStatus.Experimental
interface ErrorReportSink {
    suspend fun submit(report: UnhandledErrorReport)
}
```