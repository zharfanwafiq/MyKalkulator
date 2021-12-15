package com.zharfan.mykalkulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.zharfan.mykalkulator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity(),Calculator, View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        onClickButton()

    }


    override fun onEqual(view: View) {
        binding.apply {
            try {
                val expression = ExpressionBuilder(tvResult.text.toString()).build()
                val result = expression.evaluate()
                tvResult.text = (if (result % 1 > 0) result else result.toInt()).toString()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this@MainActivity, "Operator tidak dapat di jalankan", Toast.LENGTH_SHORT).show()

            }
        }

    }

    override fun onPlusMin(view: View) {
        binding.apply {
            tvResult.append("${(view as Button).text}")
        }

    }

    override fun onDot(view: View) {
        binding.apply {
            tvResult.append(".")
        }
    }

    override fun onPlus(view: View) {
        binding.apply {
            tvResult.append("${(view as Button).text}")
        }
    }

    override fun onMin(view: View) {
        binding.apply {
            tvResult.append("${(view as Button).text}")
        }
    }

    override fun onMultiply(view: View) {
        binding.apply {
            tvResult.append("${(view as Button).text}")
        }
    }

    override fun onClear(view: View) {
        binding.apply {
            tvResult.text = "0"
        }
    }

    override fun onKurung(view: View) {
        binding.apply {
            val resultBeforeKurung: String =tvResult.text.toString()
            if (resultBeforeKurung.isBlank()){
                tvResult.text = "("
            }else{
                tvResult.text = resultBeforeKurung + ")"
            }
        }
    }

    override fun onPercent(view: View) {
        binding.apply {
            tvResult.text = "%"
        }
    }

    override fun onDivide(view: View) {
        binding.apply {
            tvResult.append("${(view as Button).text}")
        }
    }



    override fun onDelete(view: View) {
        binding.apply {
            val resultAfterDel: String = tvResult.text.toString()
            if (resultAfterDel.isNotEmpty()) {
                tvResult.text = resultAfterDel.dropLast(n = 1)
            } else tvResult.text = "0"
        }
    }

    override fun onDigit(view: View) {
        binding.apply {
            if (tvResult.text.toString().trim() == "0") tvResult.text = ""
            tvResult.append((view as Button).text.toString())
        }

    }

    private fun onClickButton(){
        binding.apply {
            btnHistory.setOnClickListener((this@MainActivity))
        }
    }

    override fun onHistory(view: View) {
        binding.apply {

        }
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.btnHistory -> {
                startActivity(Intent(this, HistoryActivity::class.java))
            }
        }
    }


}