package com.example.diceroller
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun generates_number() {
        val dice = Dice(6)
        val roll = dice.roll()
        assertTrue(" test failed : random number is out of range (1.6)", roll in 1..6)
    }

}