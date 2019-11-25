package com.lucassimoesmartins.quickgames


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_rock_paper_scissors.*


class RockPaperScissorsFragment : Fragment(), View.OnClickListener {

    lateinit var frameAnimation : AnimationDrawable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rock_paper_scissors, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUI()
    }

    private fun setUI() {
        imgRock.setOnClickListener(this)
        imgPaper.setOnClickListener(this)
        imgscissors.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgRock -> {
                startGame(R.drawable.rock)
            }
            R.id.imgPaper -> {
                startGame(R.drawable.paper)
            }
            R.id.imgscissors -> {
                startGame(R.drawable.scissors)
            }
        }
    }

    private fun startGame(playerChoice: Int) {

        setPlayerChoice(playerChoice)

        setRivalChoiceAnimation()

        setRandomChoice(playerChoice)
    }

    private fun setPlayerChoice(playerChoice: Int) {
        //Set player choice
        imgChosen.setImageResource(playerChoice)
    }

    private fun setRivalChoiceAnimation() {
        //Set rival choice animation
        imgRival.setBackgroundResource(R.drawable.anim_random_image)
        frameAnimation = imgRival.background as AnimationDrawable
        frameAnimation.start()
    }

    private fun setRandomChoice(playerChoice: Int) {
        //Random choice
        val options = arrayOf(R.drawable.rock, R.drawable.paper, R.drawable.scissors)
        val randomNumber = (0..2).random()
        val rivalChoice = options[randomNumber]

        Thread {
            Thread.sleep(1000)
            frameAnimation?.stop()

            imgRival.setBackgroundResource(rivalChoice)

            if (playerChoice == rivalChoice) {

                changeTextResult("Tie")

            } else if (
                playerChoice == R.drawable.rock && rivalChoice == R.drawable.scissors ||
                playerChoice == R.drawable.paper && rivalChoice == R.drawable.rock ||
                playerChoice == R.drawable.scissors && rivalChoice == R.drawable.paper) {

                changeTextResult("You win")
            } else {

                changeTextResult("You lose")
            }

        }.start()
    }

    private fun changeTextResult(result : String){
        activity?.runOnUiThread {
            txtResult.text = result
        }
    }

}
