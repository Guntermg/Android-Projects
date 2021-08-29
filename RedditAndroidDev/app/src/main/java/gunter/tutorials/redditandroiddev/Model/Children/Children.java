package gunter.tutorials.redditandroiddev.Model.Children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import gunter.tutorials.redditandroiddev.Model.Children.Data;

public class Children {
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
        return "Children{" +
                "data=" + data +
                '}';
    }
}
