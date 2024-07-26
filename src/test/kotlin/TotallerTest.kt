import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Example of using test.
 * In case the test failed, it will throw an exception.
 */
class TotallerTest {
    @Test
    fun shouldBeAbleToAdd3And4() {
        val totaller = Totaller()

        Assertions.assertEquals(3, totaller.add(3))
        Assertions.assertEquals(7, totaller.add(4))
        Assertions.assertEquals(7, totaller.total)
    }
}