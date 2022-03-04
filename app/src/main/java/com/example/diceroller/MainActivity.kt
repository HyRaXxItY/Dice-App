package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


// everything that goes into activity comes here
class MainActivity : AppCompatActivity() {

    // every functionality is here for the activity screen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRoll: Button = findViewById(R.id.button)
        val text1: TextView = findViewById(R.id.textView)

        // click listener addition on the button

        buttonRoll.setOnClickListener { val res = rollDice(); displayText(res) ; text1.text = " dice rolled :"  }    /* we directly call the rollDice function
                                                                from the below function block*/
        rollDice()

    }


    // creates a function that sets the result on the textView
    private fun rollDice(): Int {
        // calling the Dice object and roll with 6 side
        val dice = Dice(6)
        val result = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView)
        when (result){
            1 -> { diceImage.setImageResource(R.drawable.dice_1) }
            2 -> { diceImage.setImageResource(R.drawable.dice_2) }
            3 -> { diceImage.setImageResource(R.drawable.dice_3) }
            4 -> { diceImage.setImageResource(R.drawable.dice_4) }
            5 -> { diceImage.setImageResource(R.drawable.dice_5) }
            6 -> { diceImage.setImageResource(R.drawable.dice_6) }
        }
        return result
    }

    private fun displayText (number: Int) {
        val textRoll: TextView = findViewById(R.id.textView2)
        when (number){
            1-> textRoll.text = "1"
            2-> textRoll.text = "2"
            3-> textRoll.text = "3"
            4-> textRoll.text = "4"
            5-> textRoll.text = "5"
            6-> textRoll.text = "6"

        }
    }
}


// creates a class for roll function
class Dice(private val side: Int) {     /* as side is private, it can be used only in Dice class.
                                            so whenever we call Dice class, only then we can use
                                            side variable */
    fun roll(): Int {
        return (1..side).random()
    }
}