# Gofra

## Extremely fast, asynchronous event bus for kotlin

### Install

```kotlin
repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/06ED/Gofra")
    }
}

dependencies {
    implementation("com.github.06ED:gofra:1.0")
}
```

### Example

```kotlin
class BenchmarkEventData(val data: String, val meow: List<String>)

object BenchmarkEvent : Gofra<BenchmarkEventData>()

suspend fun main() {
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