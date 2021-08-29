package gunter.tutorials.redditandroiddev

import com.google.gson.annotations.SerializedName
import gunter.tutorials.redditandroiddev.Model.Data

data class Feed(@SerializedName("kind") var kind:String, @SerializedName("data") var data: Data)
