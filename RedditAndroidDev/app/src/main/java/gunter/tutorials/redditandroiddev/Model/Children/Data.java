package gunter.tutorials.redditandroiddev.Model.Children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("subreddit")
    @Expose
    private String subreddit;

    @SerializedName("author_fullname")
    @Expose
    private String author_fullname;

    @SerializedName("title")
    @Expose
    private String title;


    // Getters and Setters
    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getAuthor_fullname() {
        return author_fullname;
    }

    public void setAuthor_fullname(String author_fullname) {
        this.author_fullname = author_fullname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // toString()
    @Override
    public String toString() {
        return "Data{" +
                "subreddit='" + subreddit + '\'' +
                ", author_fullname='" + author_fullname + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
