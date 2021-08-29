package gunter.tutorials.redditandroiddev

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET(".json?raw_json=1")
    fun getFeed() : Call<Feed>

    companion object {

        var BASE_URL = "https://www.reddit.com/r/androiddev/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}