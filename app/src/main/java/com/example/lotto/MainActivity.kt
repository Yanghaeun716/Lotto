package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import java.util.*
import kotlin.collections.ArrayList

fun getRandomLottoNumber (): Int{
    return Random().nextInt(45)+1
}
fun getRandomLottoNumbers(): MutableList<Int>{
    val lottoNumbers = mutableListOf<Int>()

    while(true){
        val number = getRandomLottoNumber()
        var flag_exist = 0

        if(lottoNumbers.size <1){
            lottoNumbers.add(number)
            continue
        }
        else {
            for (j in 0 until lottoNumbers.size) {
                if (number == lottoNumbers[j]) {
                    flag_exist = 1
                    break
                }
            }
            if (flag_exist == 0)
                lottoNumbers.add(number)
            if (lottoNumbers.size >= 6)
                break
        }
    }
    return lottoNumbers
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val cardRandom = findViewById<CardView>(R.id.cardRandom)
        cardRandom.setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))
            startActivity(intent)
        }

        val cardConstellation = findViewById<CardView>(R.id.cardConstellation)
        cardConstellation.setOnClickListener{
            startActivity(Intent(this, ConstellationActivity::class.java))
        }

        val cardName = findViewById<CardView>(R.id.cardName)
        cardName.setOnClickListener{
            startActivity(Intent(this, NameActivity::class.java))
        }

    }
}
