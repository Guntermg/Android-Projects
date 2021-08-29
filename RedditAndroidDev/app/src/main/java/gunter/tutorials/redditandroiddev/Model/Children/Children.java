package gunter.tutorials.redditandroiddev.Model.Children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import gunter.tutorials.redditandroiddev.Model.Children.Data;

public class Children {
    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("data")
    @Expose
    private Data data;

    // Getters and Setters
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

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
                "kind='" + kind + '\'' +
                ", data=" + data +
                '}';
    }
}
