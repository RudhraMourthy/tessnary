package com.vish.imagetotext.ocr.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.croppersample.R;

import java.util.List;

public class json_activity extends AppCompatActivity {
    TextView result;
    Retrofit.Builder builder;
    Retrofit retrofit;
    HerokuClient client;
    Call<HerokuResponse> call;
    String finals = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_activity);
        result = (TextView) findViewById(R.id.result);
        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("key").toLowerCase();
        OkHttpClient.Builder ok_builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor log = new HttpLoggingInterceptor();
        log.setLevel(HttpLoggingInterceptor.Level.BODY);
        ok_builder.addInterceptor(log);
        builder = new Retrofit.Builder()
                .baseUrl("https://od-api.oxforddictionaries.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(ok_builder.build());
        retrofit = builder.build();
        client = retrofit.create(HerokuClient.class);
        //String word = ed1.getText().toString();
        call = client.GetResponse(text);
        call.clone().enqueue(new Callback<HerokuResponse>() {
            @Override
            public void onResponse(Call<HerokuResponse> call, Response<HerokuResponse> response) {
                HerokuResponse ls = response.body();
                List<LexicalEntries> rs = ls.getMetadata().get(0).getLexicalEntries();
                for (int i = 0; i < rs.size(); i++)
                {
                    String result = rs.get(i).getEntries().get(0).getSenses().get(0).getDefinitions()[0];
                    finals = finals + result + "\n\n";
                    System.out.println(finals);
                }
                result.setTextSize(20);
                result.setText(finals);
            }

            @Override
            public void onFailure(Call<HerokuResponse> call, Throwable t) {
                Toast.makeText(json_activity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
        public void onclicked(View v)
    {
        Intent i = new Intent(json_activity.this,main.class);
        startActivity(i);
    }


}








