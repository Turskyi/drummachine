[![Stand With Ukraine](https://raw.githubusercontent.com/vshymanskyy/StandWithUkraine/main/banner-direct-single.svg)](https://stand-with-ukraine.pp.ua)
<img alt="GitHub commit activity" src="https://img.shields.io/github/commit-activity/m/Turskyi/drummachine">

# Pure Kotlin Project

This is a pure Kotlin project demonstrating the use of Kotlin features such as
classes, unit testing with JUnit, and coroutines for concurrent programming.
The project is not an Android project and runs on the JVM.

## Project Structure

The project consists of three main components:

1. **Totaller Class**: A simple class that adds numbers to a total.
2. **TotallerTest Class**: A unit test class for the Totaller class using JUnit.
3. **Main** Function with Coroutines: Demonstrates the use of Kotlin
4. coroutines and plays audio files.

## Totaller Class

This class maintains a running total of numbers added to it.

```kotlin
class Totaller(var total: Int = 0) {
    fun add(num: Int): Int {
        total += num
        return total
    }
}
```

## TotallerTest Class

This class tests the functionality of the Totaller class.

```kotlin
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TotallerTest {
    @Test
    fun shouldBeAbleToAdd3And4() {
        val totaller = Totaller()
        Assertions.assertEquals(3, totaller.add(3))
        Assertions.assertEquals(7, totaller.add(4))
        Assertions.assertEquals(7, totaller.total)
    }
}
```

## Main Function with Coroutines

This demonstrates the use of Kotlin coroutines to play audio beats concurrently.

```kotlin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import javax.sound.sampled.AudioSystem

suspend fun playBeats(beats: String, file: String) {
    val parts = beats.split("x")
    var count = 0
    for (part in parts) {
        count += part.length + 1
        if (part == "") {
            playSound(file)
        } else {
            delay(100 * (part.length + 1L))
            if (count < beats.length) {
                playSound(file)
            }
        }
    }
}

fun playSound(file: String) {
    val clip = AudioSystem.getClip()
    val audioInputStream = AudioSystem.getAudioInputStream(File(file))
    clip.open(audioInputStream)
    clip.start()
}

fun main() {
    runBlocking {
        launch {
            playBeats("x-x-x-x-x-x", "audio/toms.aiff")
        }
        launch {
            playBeats("x----x----x", "audio/crash_cymbal.aiff")
        }
        playBeats("--x--x---x-", "audio/high_hat.aiff")
    }
}
```

## How to Run the Project

### Prerequisites

- JDK 1.8 or higher
- Gradle

## Running the Tests

To run the unit tests, use the following command:

```sh
./gradlew test
```

## Notes

- Ensure you have the required audio files (toms.aiff, crash_cymbal.aiff,
  high_hat.aiff) in the audio directory relative to the project root.
- This project uses kotlinx.coroutines for coroutine support and
  javax.sound.sampled for audio playback.

## Conclusion

This project showcases the simplicity and power of Kotlin for JVM applications.
It demonstrates unit testing with JUnit and concurrent programming with
coroutines, making it a great example for learning and reference.