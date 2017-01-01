package android.fuckin.rash.jp.oddoreven

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var textViewName : TextView
    lateinit var textViewResult : TextView
    lateinit var imageDiceLeft : ImageView
    lateinit var imageDiceRight : ImageView
    lateinit var buttonGame : Button
    val rand = Random()

    val diceImages = arrayOf(
            R.drawable.alea_a1,
            R.drawable.alea_2,
            R.drawable.alea_3,
            R.drawable.alea_4,
            R.drawable.alea_5,
            R.drawable.alea_6
            )

    val names = arrayOf(
            arrayOf(R.string.name11, R.string.name12, R.string.name13, R.string.name14, R.string.name15, R.string.name16),
            arrayOf(R.string.name22, R.string.name23, R.string.name24, R.string.name25, R.string.name26),
            arrayOf(R.string.name33, R.string.name34, R.string.name35, R.string.name36),
            arrayOf(R.string.name44, R.string.name45, R.string.name46),
            arrayOf(R.string.name55, R.string.name56),
            arrayOf(R.string.name66)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        println("[names]" + names.javaClass.toString())
        println("[names[0]]" + names[0].javaClass.toString())
        println("[names[0][0]]" + names[0][0].javaClass.toString())

        //結果
        textViewName = findViewById(R.id.text_view_name) as TextView
        textViewResult = findViewById(R.id.text_view_result) as TextView
        imageDiceLeft = findViewById(R.id.image_view_left) as ImageView
        imageDiceRight = findViewById(R.id.image_view_right) as ImageView

        //勝負ボタン
        buttonGame = findViewById(R.id.button_game) as Button
        buttonGame.setOnClickListener {
            val dice1 = rand.nextInt(6)
            val dice2 = rand.nextInt(6)
            val result = (dice1 + 1) + (dice2 + 1)

            //サイコロ
            imageDiceLeft.setImageResource(diceImages[dice1])
            imageDiceRight.setImageResource(diceImages[dice2])

            //結果
            textViewResult.text = getString(if (result % 2 == 0) R.string.result_cho else R.string.result_han)

            //呼称
            val min = if (dice1 < dice2) dice1 else dice2
            val max = if (dice1 > dice2) dice1 else dice2
            //println("$min, $max")
            val name = getString(names[min][max-min]) + getString(R.string.name_no)
            //println("[name] " + name.javaClass.toString())
            textViewName.text = name//getString(names[min][max-min]) + getString(R.string.name_no)
        }
    }
}
