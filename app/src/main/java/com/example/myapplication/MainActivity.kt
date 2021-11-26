package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    private lateinit var button9 : Button

    private lateinit var buttonNext : Button
    private lateinit var buttonRestart : Button






    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        buttonNext = findViewById(R.id.buttonNext)
        buttonRestart = findViewById(R.id.buttonRestart)

        buttonNext.setOnClickListener {
            nextRound()
        }
        buttonRestart.setOnClickListener {
            restartGame()
        }




    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button){
            var buttonNumber = 0
            when(clickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9


                
            }
            if (buttonNumber != 0){
                playGame(clickedView, buttonNumber)
                
            } 
            
        }
        
    }




    private fun init(){

        button1 = (findViewById(R.id.button1))
        button2 = (findViewById(R.id.button2))
        button3 = (findViewById(R.id.button3))
        button4 = (findViewById(R.id.button4))
        button5 = (findViewById(R.id.button5))
        button6 = (findViewById(R.id.button6))
        button7 = (findViewById(R.id.button7))
        button8 = (findViewById(R.id.button8))
        button9 = (findViewById(R.id.button9))


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)



    }

    private fun playGame(clickedView: Button, buttonNumber: Int) {

        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            firstPlayer.add(buttonNumber)
            activePlayer = 2


        }else {
            clickedView.text="O"
            clickedView.setBackgroundColor(Color.BLUE)
            secondPlayer.add(buttonNumber)
            activePlayer = 1


        }
        clickedView.isEnabled = false
        check()

    }

        var scoreCounter1 = 0
        var scoreCounter2 = 0


    private fun check() {

        var winnerPlayer = -1
        val firstScore: TextView = findViewById(R.id.firstScore)
        val secondScore: TextView = findViewById(R.id.secondScore)


        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2

        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1

        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2

        }
        if (winnerPlayer != 1 && winnerPlayer != 2 && !button1.isEnabled && !button2.isEnabled && !button3.isEnabled && !button4.isEnabled && !button5.isEnabled && !button6.isEnabled && !button7.isEnabled && !button8.isEnabled && !button9.isEnabled) {
            winnerPlayer = 3
        }
//        if (winnerPlayer == -1){
//            buttonNext.isEnabled = false
//        }







        if (winnerPlayer == 1){
            Toast.makeText(this, "First player won!", Toast.LENGTH_SHORT).show()

            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false


            scoreCounter1 += 1
            firstScore.text = "$scoreCounter1"



        }else if (winnerPlayer == 2){
            Toast.makeText(this, "Second player won!", Toast.LENGTH_SHORT).show()

            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false


            scoreCounter2 += 1
            secondScore.text = "$scoreCounter2"



        }else if (winnerPlayer == 3){
            Toast.makeText(this, " Draw!", Toast.LENGTH_SHORT).show()






        }


    }

    @SuppressLint("ResourceAsColor")
    fun nextRound(){

        activePlayer = 1
        firstPlayer.clear()
        secondPlayer.clear()


        for (buttonNumber in 1..9){

            var clickedView:Button? = when(buttonNumber){
                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else ->{button1}

            }
            clickedView!!.setBackgroundColor(R.color.purple_200)
            clickedView!!.text= ""
            clickedView!!.isEnabled = true
        }


    }

    @SuppressLint("ResourceAsColor")
    fun restartGame(){

        val firstScore:TextView = findViewById(R.id.firstScore)
        val secondScore:TextView = findViewById(R.id.secondScore)
        activePlayer = 1
        firstPlayer.clear()
        secondPlayer.clear()
        firstScore.text = "0"
        secondScore.text = "0"
        scoreCounter1 = 0
        scoreCounter2 = 0


        for (buttonNumber in 1..9){

            var clickedView:Button? = when(buttonNumber){
                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else ->{button1}

            }
            clickedView!!.setBackgroundColor(R.color.purple_700)
            clickedView!!.text= ""
            clickedView!!.isEnabled = true
        }


    }




}