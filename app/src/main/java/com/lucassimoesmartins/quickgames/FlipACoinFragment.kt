package com.lucassimoesmartins.quickgames


import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_flip_acoin.*


class FlipACoinFragment : Fragment(), View.OnClickListener {

    lateinit var frameAnimation: AnimationDrawable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flip_acoin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUI()
    }

    private fun setUI() {
        imgHead.setOnClickListener(this)
        imgTail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.imgHead -> {
                startGame(R.drawable.head)
            }
            R.id.imgTail -> {
                startGame(R.drawable.tail)
            }
        }
    }

    private fun startGame(playerChoice: Int) {

        setPlayerChoice(playerChoice)

        setRivalChoiceAnimation()

        setRandomChoice(playerChoice)

    }

    private fun setPlayerChoice(playerChoice: Int) {
        imgChosen.setImageResource(playerChoice)
    }

    private fun setRivalChoiceAnimation() {
        imgRival.setBackgroundResource(R.drawable.anim_random_head_tail)
        frameAnimation = imgRival.background as AnimationDrawable
        frameAnimation.start()
    }

    private fun setRandomChoice(playerChoice: Int) {
        //Random choice
        val options = arrayOf(R.drawable.head, R.drawable.tail)
        val randomNumber = (0..1).random()
        val rivalChoice = options[randomNumber]

        Thread {
            Thread.sleep(1000)
            frameAnimation?.stop()

            imgRival.setBackgroundResource(rivalChoice)

            if (playerChoice == rivalChoice) {

                changeTextResult("You win")

            } else {

                changeTextResult("You lose")
            }

        }.start()
    }

    private fun changeTextResult(result: String) {
        activity?.runOnUiThread {
            txtResult.text = result
        }
    }
}
