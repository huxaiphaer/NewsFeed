package oerrride.we.huzykamz.newsfeed;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HUZY_KAMZ on 2/20/2016.
 */
public class NewsModel {


  //  @SerializedName("Headlines")
    private String Headlines;
   // @SerializedName("Details")
    private String Details;
    private Bitmap bitmap;
 //   @SerializedName("photo")
    private String photo;




    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getHeadlines() {
        return Headlines;
    }

    public void setHeadlines(String headlines) {
        Headlines = headlines;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
}
