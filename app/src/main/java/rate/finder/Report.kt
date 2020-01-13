package rate.finder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class Report : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        //Get the bundle
        val bundle = intent.extras

        //Extract the data…
        val data1 = bundle!!.getString("KEY1")
        val data2 = bundle.getString("KEY2")
        val data3 = bundle.getString("KEY3")
        val data4 = bundle.getString("KEY4")

        //Config Fields
        val reportLn1 = findViewById<TextView>(R.id.reportLength)
        val reportLn2 = findViewById<TextView>(R.id.reportBreadth)
        val reportLn3 = findViewById<TextView>(R.id.reportHeight)
        val reportLn4 = findViewById<TextView>(R.id.reportWeight)

        //Set bundle into Edit Texts
        reportLn1.text = data1!!
        reportLn2.text = data2!!
        reportLn3.text = data3!!
        reportLn4.text = data4!!

    }
}
