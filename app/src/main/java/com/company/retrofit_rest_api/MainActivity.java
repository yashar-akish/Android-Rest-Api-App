package com.company.retrofit_rest_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textA, textB, textC, textD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textA = findViewById(R.id.textViewA);
        textB = findViewById(R.id.textViewB);
        textC = findViewById(R.id.textViewC);
        textD = findViewById(R.id.textViewD);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);

        Call<List<ModelClass>> call = retrofitApi.getModelClass();

        call.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                if (!response.isSuccessful()){
                    textA.setText("error");
                    textB.setText("error");
                    textC.setText("error");
                    textD.setText("error");
                }

                List<ModelClass> data = response.body();

                textA.setText(""+data.get(0).getUserId());
                textB.setText(""+data.get(0).getId());
                textC.setText(""+data.get(0).getTitle());
                textD.setText(""+data.get(0).getSubTitle());
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "There is an error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}