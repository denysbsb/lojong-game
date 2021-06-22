package com.lojong.activity


import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.airbnb.lottie.LottieAnimationView
import com.lojong.viewmodel.GameViewModel
import com.lojong.R
import com.skydoves.balloon.ArrowOrientation
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.Balloon
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec.WRAP


class GameActivity : AppCompatActivity() {

    lateinit var step1: RelativeLayout
    lateinit var step2:RelativeLayout
    lateinit var step3:RelativeLayout
    lateinit var step4:RelativeLayout
    lateinit var step5 :RelativeLayout
    lateinit var elefante1:LottieAnimationView
    lateinit var elefante2:LottieAnimationView
    lateinit var elefante3:LottieAnimationView
    lateinit var elefante4:LottieAnimationView
    lateinit var elefante5: LottieAnimationView

    private lateinit var viewModel: GameViewModel
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        step1 = findViewById(R.id.step1)
        step2 = findViewById(R.id.step2)
        step3 = findViewById(R.id.step3)
        step4 = findViewById(R.id.step4)
        step5 = findViewById(R.id.step5)
        elefante1 = findViewById(R.id.elefante1)
        elefante2 = findViewById(R.id.elefante2)
        elefante3 = findViewById(R.id.elefante3)
        elefante4 = findViewById(R.id.elefante4)
        elefante5 = findViewById(R.id.elefante5)
        
        step1.setOnClickListener {
            hideShow(elefante1, step1, 1)
        }

        step2.setOnClickListener {
            hideShow(elefante2, step2 ,2)
        }

        step3.setOnClickListener {
            hideShow(elefante3, step3, 3)
        }
        step4.setOnClickListener {
            hideShow(elefante4, step4, 4)
        }
        step5.setOnClickListener {
            hideShow(elefante5, step5, 5)
        }

        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        viewModel.getState()
    }

    fun hideShow(elefante:LottieAnimationView,step: RelativeLayout, number: Int){
        elefante1.visibility = View.GONE
        step1.visibility = View.VISIBLE
        elefante2.visibility = View.GONE
        step2.visibility = View.VISIBLE
        elefante3.visibility = View.GONE
        step3.visibility = View.VISIBLE
        elefante4.visibility = View.GONE
        step4.visibility = View.VISIBLE
        elefante5.visibility = View.GONE
        step5.visibility = View.VISIBLE

        elefante.visibility = View.VISIBLE
        step.visibility = View.GONE

        showBallor(step,number)
        viewModel.setState()
    }

    fun showBallor(step: RelativeLayout, number: Int) {
        val balloon: Balloon = Balloon.Builder(applicationContext)
            .setArrowSize(10)
            .setArrowOrientation(ArrowOrientation.TOP)
            .setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
            .setArrowPosition(0.5f)
            .setWidth(WRAP)
            .setHeight(85)
            .setTextSize(15f)
            .setCornerRadius(4f)
            .setMarginBottom(20)
            .setPadding(10)
            .setAlpha(0.9f)
            .setText("Você estar no passo "+number)
            .setTextColor(ContextCompat.getColor(this, R.color.black))
            .setTextIsHtml(true)
            .setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            .setBalloonAnimation(BalloonAnimation.FADE)
            .build()

        balloon.show(step)
    }
}