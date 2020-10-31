import java.io.File
import javax.sound.sampled.AudioSystem
import kotlinx.coroutines.*

suspend fun playBeats(beats: String, file: String){
    val parts = beats.split("x")
    var count = 0
    for(part in parts){
        count += part.length + 1
        if (part == ""){
            playSound(file)
        } else {
            delay(100 * (part.length + 1L))
            if (count < beats.length){
                playSound(file)
            }
        }
    }
}

fun playSound(file: String) {
    val clip = AudioSystem.getClip()
    val audioInputStream = AudioSystem.getAudioInputStream(
        File(file)
    )
    clip.open(audioInputStream)
    clip.start()
}

fun main(){
    /**
     * “The runBlocking function blocks the current thread until the code it contains has finished running.”
     * it allows us to launch many coroutines in one thread
     */
    runBlocking {
        launch{
            playBeats("x-x-x-x-x-x-","audio/toms.aiff")
        }
        playBeats("x----x----","audio/crash_cymbal.aiff")
    }
}
