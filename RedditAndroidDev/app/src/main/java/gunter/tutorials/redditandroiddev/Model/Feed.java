package gunter.tutorials.redditandroiddev.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Feed {
    @SerializedName("data")
    @Expose
    private Data data;

    // Getters and Setters
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    // toString()
    @Override
    public String toString() {
        return "Feed{" +
                "data=" + data +
                '}';
    }
}
