package jp.techacademy.takashige.aisatsuapp

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    // var age: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        showTimePickerDialog()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    Log.d("UI_PARTS", "$hour:$minute")
                    val Time:Int = 60 * hour + minute
                    if (120 <= Time && Time <= 599) {
                        textView.text = "おはよう"
                    }
                    else if (600 <= Time && Time <= 1079) {
                        textView.text = "こんにちは"
                    }
                    else if (1080 <= Time || Time <= 119) {
                        textView.text = "こんばんは"
                    }
                },
                13, 0, true)
        timePickerDialog.show()
    }
}

