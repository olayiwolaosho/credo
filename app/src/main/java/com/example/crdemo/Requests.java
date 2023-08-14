package com.example.crdemo;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Requests {

    @Headers({"Cache-Control: max-age=640000", "loginid: AP02727", "password:qwerty"})
    @POST("api?qid=010")
    Call<Object> createUser();

    @Headers({"Cache-Control: max-age=640000", "jwt: '{}' "})
    @POST("api?qid=012")
    Call<Object> downloadUsers();


}
