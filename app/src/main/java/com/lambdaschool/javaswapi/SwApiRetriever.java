package com.lambdaschool.javaswapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.GsonBuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SwApiRetriever {
    public final static String TAG = "RETRIEVER";
    public final static String BASE_URL = "https://swapi.co/api/";

    public Call<SwApiPeople> getPeople(String page) {
        Gson gson = new GsonBuilder().setLenient().create();

        /*OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(false);
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(10, TimeUnit.SECONDS);
        OkHttpClient build = builder.build();*/

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(SwApi.class).getPeople(page);
    }

    public Call<SwApiPeople> getPeople() {
        return getPeople("1");
    }
}
