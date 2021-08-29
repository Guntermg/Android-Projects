package gunter.tutorials.redditandroiddev.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Feed {
    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("kind")
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
        return "Feed{" +
                "kind='" + kind + '\'' +
                ", data=" + data +
                '}';
    }
}
