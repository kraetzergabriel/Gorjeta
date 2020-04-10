package org.senac.gabrielkraetzer.prova1

import android.os.Bundle
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.senac.gabrielkraetzer.repository.Tip
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var amount : EditText
    private lateinit var rate : SeekBar;
    private lateinit var txRate : TextView
    private lateinit var tipFixed : EditText
    private lateinit var tipPercent : EditText
    private lateinit var totalTipFixed : EditText
    private lateinit var totalTipPercent : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.initialize();

        this.rate.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                txRate.text = "$progress%"

                var tip = Tip(amount.text.toString().toDouble(), progress.toDouble())
                val fixed = tip.returnTipFixed()
                val percent = tip.returnTipPercent()

                tipFixed.setText("${String.format("R$%.2f", fixed)}")
                tipPercent.setText("${String.format("R$%.2f", percent)}")
                totalTipFixed.setText("${String.format("R$%.2f",tip.amount + fixed)}")
                totalTipPercent.setText("${String.format("R$%.2f",tip.amount + percent)}")

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }
    private fun initialize() {
        this.amount = findViewById(R.id.edAmount)
        this.rate = findViewById(R.id.sbRate)
        this.txRate = findViewById(R.id.txRate)
        this.tipFixed = findViewById(R.id.edTipFixed)
        this.tipPercent = findViewById(R.id.edTipPercent)
        this.totalTipFixed = findViewById(R.id.edTotalTipFixed)
        this.totalTipPercent = findViewById(R.id.edTotalTipPercent)

    }
}
