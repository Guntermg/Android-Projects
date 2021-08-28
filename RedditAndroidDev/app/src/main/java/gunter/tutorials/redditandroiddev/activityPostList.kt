package gunter.tutorials.redditandroiddev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.json.JSONObject
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class activityPostList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_list)

        /*try {
            val result = GlobalScope.async {
                callAPI("https://www.reddit.com/r/androiddev.json?raw_json=1")
            }

            if (result != null) {
                Toast.makeText(this, "Deu ruim!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Tem alguma coisa!", Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }*/
    }

        // DOES NOT WORK
    private fun callAPI(apiURL: String):String? {
        // Link to API: https://www.reddit.com/r/androiddev.json?raw_json=1
        var result: String? = ""
        val url: URL;
        var connection: HttpURLConnection? = null
        try {
            url = URL(apiURL)
            connection = url.openConnection() as HttpURLConnection

            // set the request method - GET
            connection.requestMethod = "GET"
            val `in` = connection.inputStream
            val reader = InputStreamReader(`in`)
            // read the response data
            var data = reader.read()
            while (data != -1) {
                val current = data.toChar()
                result += current
                data = reader.read()
            }
            return result
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null

        TODO("call  the mf api")
    }
}


// MANUAL VERSIONING:
//
// - added internet permission on manifest xml
// - added kotlinx coroutines on build.gradle