package com.example.crdemo.services;

import android.renderscript.RenderScript;
import android.util.Log;

import com.example.crdemo.Requests;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpService {

    private static final String TAG = "HttpService ";

    private static String jwt = " ";

    public static final String BASE_URL = "https://crdemo.ipolongo.org/";

    private static Retrofit retro(){
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }


        public static synchronized void login(){

            Requests apiService =
                    retro().create(Requests.class);

            Call<Object> call = apiService.createUser();

            call.enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    Log.i(TAG + "response",response.toString());
                    //jwt = jwt;
                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {
                    // Log error here since request failed
                }
            });


        }



        public static synchronized void downloadUsers(){

            Requests apiService =
                    retro().create(Requests.class);

            String url = "https://crdemo.ipolongo.org/api?qid=012";

            Call<Object> call = apiService.downloadUsers();

            call.enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    Log.i(TAG + "response",response.toString());

                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {
                    // Log error here since request failed
                }
            });



            /*AndroidNetworking.post(url)
                    .addHeaders("loginid", "AP02727")
                    .addHeaders("password", "qwerty")
                    .addHeaders("device_id", "ACE4078")
                    .setPriority(RenderScript.Priority.NORMAL)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // do anything with response

                            Log.i("response",response.toString());

                        }
                        @Override
                        public void onError(ANError error) {
                            // handle error
                        }
                    });*/

        }

}
