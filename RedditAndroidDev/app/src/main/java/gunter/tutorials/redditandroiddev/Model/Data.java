package gunter.tutorials.redditandroiddev.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import gunter.tutorials.redditandroiddev.Model.Children.Children;

public class Data {
    @SerializedName("children")
    @Expose
    private ArrayList<Children> children;

    // Getters and Setters
    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }

    // toString()
    @Override
    public String toString() {
        return "Data{" +
                "children=" + children +
                '}';
    }
}
