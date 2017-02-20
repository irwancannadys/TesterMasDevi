package com.example.irwancannady.testermasdevi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by adhitiahidayat on 10/27/16.
 */

public interface ApiInterface {


    @GET("v1/version")
    Call<Model> postData(@Query("device_id") String device_id,
                         @Query("android_version") String android_version,
                         @Query("app_version") String app_version);

    @GET("index.php/api/getKost")
    Call<List<ModelDua>> getData();

    @GET("api/bmkg?view=provinsi&k=8f3d440d802b060d2852f6f6ad391fc8")
    Call<Model3> getIbacor();

}
