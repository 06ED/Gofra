# Gofra

## Extremely fast, asynchronous event bus for kotlin

### Install
```kotlin

```

### Example
```kotlin
class BenchmarkEventData(val data: String, val meow: List<String>)

object BenchmarkEvent : Gofra<BenchmarkEventData>()

fun main() {
    repeat(100) {
        BenchmarkEvent.subscribe(EventListener {
            // TODO
        })
    }

    repeat(1_000_000) {
        BenchmarkEvent.notify(BenchmarkEventData(data = "", meow = emptyList()))
    }
}
```