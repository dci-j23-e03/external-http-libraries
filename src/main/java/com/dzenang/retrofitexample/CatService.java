package com.dzenang.retrofitexample;

import retrofit2.Call;
import retrofit2.http.*;

public interface CatService {

    @GET("/fact")
    Call<CatFact> getCatFact();
}
