package gunter.tutorials.redditandroiddev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);   // Hide the title
        getSupportActionBar()!!.hide();                  // Hide the title bar
        this.getWindow()!!.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // Enable full screen

        setContentView(R.layout.activity_main)


        // Go to next activity on button click
        btnGo.setOnClickListener {
            val intent = Intent(this, activityPostList::class.java)
            startActivity(intent)
            finish()
        }
    }
}