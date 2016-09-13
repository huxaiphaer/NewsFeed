package oerrride.we.huzykamz.newsfeed;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by HUZY_KAMZ on 9/13/2016.
 */
public class NewsAdapter2 extends RecyclerView.Adapter<NewsViewHolder> {

    String url_load_images="http://10.0.2.2/UgandaMedicalAccess/HealthCentreNews/HealthCentreNewsPics/";
    private List<NewsModel> itemList = null;
    private Context context;


    private ArrayList<NewsModel> arraylist;
    public NewsAdapter2(Context context, List<NewsModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        NewsViewHolder rcv = new NewsViewHolder(layoutView,context);
        return rcv;
    }
    public static String encodeTobase64(Bitmap image) {
        Bitmap immagex=image;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        immagex.compress(Bitmap.CompressFormat.JPEG, 90, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        // Log.e("LOOK", imageEncoded);
        return imageEncoded;
    }
    @Override
    public void onBindViewHolder(final NewsViewHolder holder,final int position) {
        final  NewsModel feedItems = itemList.get(position);



        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsAdapter2.this.context, NewsInformation.class);
                intent.putExtra(NewsViewHolder.KEY_HEADLINES, feedItems.getHeadlines());
                intent.putExtra(NewsViewHolder.KEY_DETAILS, feedItems.getDetails());

                context.startActivity(intent);


                //Download image using picasso library
                Picasso.with(context).load(url_load_images + feedItems.getPhoto())
                        .error(R.mipmap.ic_launcher).
                        resize(120, 100)
                        .placeholder(R.mipmap.ic_launcher).into(holder.newspic);

                holder.headlines.setText(itemList.get(position).getHeadlines());




            }
        });}
    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }
}
