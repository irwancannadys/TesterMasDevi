package com.example.irwancannady.testermasdevi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Second extends AppCompatActivity {

    ModelDua modelDua;
    public static final String URL = "http://ibacor.com/";
    List<Data> data;
    Model3 model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
//                getIbacor();
            }
        });
    }

    private void getData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://carikost.triseptianto.web.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<ModelDua>> call = apiInterface.getData();
        call.enqueue(new Callback<List<ModelDua>>() {
            @Override
            public void onResponse(Call<List<ModelDua>> call, Response<List<ModelDua>> response) {

                List<ModelDua> list = response.body();
                for (int i =0; i<list.size(); i++){
                    String a = list.get(i).getNama_kost();
                    Toast.makeText(Second.this, a, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelDua>> call, Throwable t) {

            }
        });
    }

    private void getIbacor(){

        Retrofit retro = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface ap = retro.create(ApiInterface.class);
        Call<Model3> ad = ap.getIbacor();
        ad.enqueue(new Callback<Model3>() {
            @Override
            public void onResponse(Call<Model3> call, Response<Model3> response) {

                Model3 model=  response.body();
                List<Data> a = model.getData();
                Toast.makeText(Second.this, a.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Model3> call, Throwable t) {

            }
        });
    }
}
