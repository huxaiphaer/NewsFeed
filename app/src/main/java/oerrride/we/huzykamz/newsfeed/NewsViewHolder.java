package oerrride.we.huzykamz.newsfeed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HUZY_KAMZ on 9/13/2016.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {
    public TextView headlines;
    public TextView details;
    public ImageView newspic;
    public static String KEY_DETAILS="details";
    public static String KEY_HEADLINES="headlines";

    public View root;



    public NewsViewHolder(final View itemView, final Context c) {
        super(itemView);
        root = itemView;






        headlines = (TextView) itemView.findViewById(R.id.headlines);
        details =(TextView) itemView.findViewById(R.id.details);
        newspic = (ImageView) itemView.findViewById(R.id.image_news);
    }


}
