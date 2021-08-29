package gunter.tutorials.redditandroiddev;

import gunter.tutorials.redditandroiddev.Model.Feed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RedditAPI {
    String BASE_URL = "https://www.reddit.com/r/androiddev";

    @Headers("Content-Type: application/json")
    @GET(".json?raw_json=1")
    Call<Feed> getData();
}
