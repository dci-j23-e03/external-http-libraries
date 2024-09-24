package com.dzenang.retrofitexample;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetrofitExample {

    public static void main(String[] args) {

        // retrofit the CatService - create implementation of CatService interface
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://catfact.ninja")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CatService catService = retrofit.create(CatService.class);

        // create request, execute, process response
        Call<CatFact> getCatFactRequest = catService.getCatFact();
        try {
            Response<CatFact> getCatFactResponse = getCatFactRequest.execute();
            System.out.println("Status code: " + getCatFactResponse.code());
            CatFact catFact = getCatFactResponse.body();
            System.out.println("Response body: " + catFact);
        } catch (IOException e) {
            System.out.println("Error executing request: " + e.getMessage());
        }
    }
}
