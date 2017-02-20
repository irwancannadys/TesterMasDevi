package com.example.irwancannady.testermasdevi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String BASE_URL = "http://192.168.120.170:9292/";
    private EditText editText,editText2,editText3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Second.class));
//                postData();
            }
        });

    }

    private void postData(){

        String a = "1111";
        String b = "aaaa";
        String c = "cccc";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<Model> call = apiInterface.postData(a,b,c);

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                try{

                    if (response.isSuccess()){
                        response.body();
                        Toast.makeText(MainActivity.this, "heyhoooo", Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "gagal", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });

    }
}
