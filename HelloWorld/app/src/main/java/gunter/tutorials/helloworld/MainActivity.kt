package gunter.tutorials.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // get reference to button
        val myButton = findViewById(R.id.button) as Button
        val myTextView = findViewById(R.id.textView) as TextView
        var timesClicked = 0
        // set on-click listener
        myButton.setOnClickListener {
            timesClicked++
            myTextView.text = timesClicked.toString()
            Toast.makeText(this@MainActivity, "Contagem incrementada.", Toast.LENGTH_SHORT).show()
        }
    }
}