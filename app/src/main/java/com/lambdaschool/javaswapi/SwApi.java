package com.lambdaschool.javaswapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SwApi {
    @GET("people")
    public Call<SwApiPeople> getPeople(@Query("page") String page);
}
