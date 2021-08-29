package gunter.tutorials.redditandroiddev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import gunter.tutorials.redditandroiddev.Model.Children.Children
import kotlinx.android.synthetic.main.activity_post_list.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class activityPostList : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);   // Hide title
        getSupportActionBar()!!.hide();                  // Hide title bar
        this.getWindow()!!.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // Enable Fullscreen
        setContentView(R.layout.activity_post_list)

        var titleList:ArrayList<Item> = ArrayList()
        // Inicializa requisição da API e exibe lista de títulos
        apiConnect()

    }


    // retornava ArrayList<String>
    private fun apiConnect() {
        val apiInterface = ApiInterface.create().getFeed()


        apiInterface.enqueue( object : Callback<Feed> {
            override fun onResponse(call: Call<Feed>?, response: Response<Feed>?) {
                if(response?.body() != null) {
                    // get API response
                    val body = response?.body()?.data?.children
                    // Set ArrayList of Item elements for recycleView
                    var titleList:ArrayList<Item> = ArrayList()
                    for ((index, item) in body!!.withIndex()) {
                        var novoItem = Item(item.data.title)
                        titleList.add(novoItem)
                    }

                    // Set recyclerView with values from API
                    val rv = recycleView
                    rv.adapter = redditTitlesAdapter(titleList, this@activityPostList)
                    val layoutManager = LinearLayoutManager(this@activityPostList)
                    rv.layoutManager = layoutManager

                }
                else {
                    Toast.makeText(applicationContext, "No posts found.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Feed>?, t: Throwable?) {
                t?.printStackTrace()
                Toast.makeText(applicationContext, "Something went wrong.", Toast.LENGTH_SHORT).show()
            }
        })
    }


    override fun onBackPressed() {
        goBacktoMain()
    }

    // If back button pressed: Go back to main
    private fun goBacktoMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}