package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()

        val flipCoin: Button = findViewById(R.id.button2)
        flipCoin.setOnClickListener { flipCoin() }

        // Do a coin flip when the app starts
        flipCoin()
    }

    // "6" it will always display 6 only used for testing of app
    // val resultTextView: TextView = findViewById(R.id.textView)
    // resultTextView.text = "6"

    // to display a "Dice Rolled!" message
    //Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()


    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    private fun flipCoin() {
        // Create new Coin object with 2 sides and flip it
        val coin = Coin(2)
        val coinFlip = coin.flip()

        // Find the ImageView in the layout
        val coinImage: ImageView = findViewById(R.id.imageView2)

        // Determine which drawable resource ID to use based on the coin flip
        val drawableResource = when (coinFlip) {
            1 -> R.drawable.group_1
            2 -> R.drawable.group_2
            else -> R.drawable.group_1
        }

        // Update the ImageView with the correct drawable resource ID
        coinImage.setImageResource(drawableResource)

        // Update the content description
        coinImage.contentDescription = coinFlip.toString()
     }

    class Coin(private val numSides: Int) {

        fun flip(): Int {
            return (1..numSides).random()
        }
    }


}