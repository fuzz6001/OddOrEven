package android.fuckin.rash.jp.oddoreven

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var textViewResult : TextView
    lateinit  var buttonGame : Button
    val rand = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        //結果
        textViewResult = findViewById(R.id.text_view_result) as TextView

        //勝負ボタン
        buttonGame = findViewById(R.id.button_game) as Button
        buttonGame.setOnClickListener {
            val dice1 = rand.nextInt(6) + 1
            val dice2 = rand.nextInt(6) + 1
            val result = dice1 + dice2
            textViewResult.text = getString(if (result % 2 == 0) R.string.result_cho else R.string.result_han)
        }
    }
}
