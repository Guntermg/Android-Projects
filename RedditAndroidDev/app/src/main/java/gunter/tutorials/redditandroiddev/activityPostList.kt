package gunter.tutorials.redditandroiddev

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

        requestWindowFeature(Window.FEATURE_NO_TITLE);   // Esconde título
        getSupportActionBar()!!.hide();                  // Esconde barra de título
        this.getWindow()!!.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // ativa modo fullscreen
        setContentView(R.layout.activity_post_list)

        var titleList:ArrayList<Item> = ArrayList()
        // Inicializa requisição da API e exibe lista de títulos
        var titles = apiConnect()

    }

    // NÃO UTILIZADA - DELETAR
    private fun updateItemList(titles: ArrayList<String>):ArrayList<Item> {
        var titleList:ArrayList<Item> = ArrayList()

        for((index, item) in titles.withIndex()) {
            var novoItem = Item(item)
            titleList.add(novoItem)
        }

        return titleList
    }

    private fun apiConnect(): ArrayList<String> {
        val apiInterface = ApiInterface.create().getFeed()  // CHECK THIS
        var titleContent: ArrayList<String> = ArrayList()

        apiInterface.enqueue( object : Callback<Feed> {
            override fun onResponse(call: Call<Feed>?, response: Response<Feed>?) {
                if(response?.body() != null) {

                    val body = response?.body()?.data?.children
                    var titleList:ArrayList<Item> = ArrayList()
//                    Toast.makeText(applicationContext, titleContent.size.toString(), Toast.LENGTH_SHORT).show()
                    for ((index, item) in body!!.withIndex()) {
                        //title = body.get(index).data.title
                        //titleContent.add(body?.get(index).data.title)
                        var novoItem = Item(item.data.title)
                        titleList.add(novoItem)
                    }
                    val rv = recycleView
                    rv.adapter = redditTitlesAdapter(titleList, this@activityPostList)
                    val layoutManager = LinearLayoutManager(this@activityPostList)
                    rv.layoutManager = layoutManager


                    //Toast.makeText(applicationContext, titleContent.size.toString(), Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(applicationContext, "it's null ?", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Feed>?, t: Throwable?) {
                t?.printStackTrace()
                Toast.makeText(applicationContext, "it's failure  :(", Toast.LENGTH_SHORT).show()
            }
        })

        return titleContent
    }

}


// MANUAL VERSIONING:
//
// - added internet permission on manifest xml
// - added kotlinx coroutines on build.gradle