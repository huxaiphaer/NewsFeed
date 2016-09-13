package oerrride.we.huzykamz.newsfeed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    ProgressBar pb;


    List<NewsModel> flowerList;
    RecyclerView mRecycler;
    NewsAdapter2 adapter;
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar) findViewById(R.id.progressBarNews);
        initViews();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    private void initViews(){
        mRecycler = (RecyclerView)findViewById(R.id.recycler_view_news);
        mRecycler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecycler.setLayoutManager(layoutManager);
        loadJSON();
    }


        //Testing




    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, retrofit2.Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                flowerList = new ArrayList<>(Arrays.asList(jsonResponse.getNews()));
                adapter = new NewsAdapter2(MainActivity.this,flowerList);
                mRecycler.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable throwable) {
                Log.d("Error",throwable.getMessage());
            }
        });


    }

/*


        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();




        final String url ="http://10.0.2.2/UgandaMedicalAccess/HealthCentreNews/fecth.php";
        if(netInfo != null && netInfo.isConnectedOrConnecting()) {
            new MyTask().execute(url);
        }
        else{
            Toast.makeText(this,"No network connection! , please check your connectivity",Toast.LENGTH_LONG).show();
        }
*/




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    protected void updateDisplay() {
        adapter = new NewsAdapter2(MainActivity.this, flowerList);
        adapter.notifyDataSetChanged();
        mRecycler.setAdapter(adapter);

    }



/*
    private class MyTask extends AsyncTask<String, String,List<NewsModel>> {

        @Override
        protected void onPreExecute() {

            setProgressBarIndeterminateVisibility(true);
        }

        @Override
        protected List<NewsModel> doInBackground(String... params) {


            String content = HttpManager.getData(params[0], "feeduser", "feedpassword");
            flowerList = NewsParser.parseFeed(content);




                    return flowerList;


        }

        @Override
        protected void onPostExecute(List<NewsModel> newsModels) {

            pb.setVisibility(View.INVISIBLE);
            if (newsModels == null) {
                Toast.makeText(MainActivity.this, "Data is  not available", Toast.LENGTH_LONG).show();
                return;
            }

            flowerList = newsModels;
            updateDisplay();
        }



    }
*/
}
