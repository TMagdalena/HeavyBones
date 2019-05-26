package com.example.heavybones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var body: Body

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculate_button.setOnClickListener { checkInputs() }
    }


    private fun checkInputs() {
        var height: Double = height_edit_text.text.toString().toDouble()
        var weight: Double = weight_edit_text.text.toString().toDouble()

        if (height > 1.2 && height < 2.5 && height != 0.0 &&
            weight > 40.0 && weight < 350.0 && weight != 0.0
        ) {
            body = Body(weight, height)
            selectBMI(body.calculateBMI())
        } else {
            Toast.makeText(this, "Error! Invalid input(s).", Toast.LENGTH_SHORT)
        }
    }

    private fun selectBMI(result: Double) {
        when (result) {
            in 0.0..18.5 -> showResult(BMIType.UNDERWEIGHT)
            in 18.5..24.9 -> showResult(BMIType.NORMAL)
            in 25.0..29.9 -> showResult(BMIType.OVERWEIGHT)
            in 30.0..50.0 -> showResult(BMIType.OBESE)
        }
    }

    private fun showResult(type: BMIType) {
        body_img.setImageResource(type.image)
        summary_text_view.text = this.getString(type.description)
        category_text_view.text = this.getString(type.type)
        result_text_view.text = "%.2f".format(body.calculateBMI())
    }
}
