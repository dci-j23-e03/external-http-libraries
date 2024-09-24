package com.dzenang;

import okhttp3.*;

import javax.imageio.IIOException;
import java.io.IOException;

public class OkHttpClientExample {

    public static void getExample() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://catfact.ninja/fact").get().build();
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            System.out.println("Response status: " + response.code());
            System.out.println("Response body: " + response.body().string());
        } catch (IOException e) {
            System.out.println("Error executing request: " + e.getMessage());
        }
    }

    public static void postExample() {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create("Hello World", MediaType.parse("text/plain"));
        Request request = new Request.Builder()
                .url("https://postman-echo.com/post")
                .post(requestBody)
                .build();
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            System.out.println("Response status: " + response.code());
            System.out.println("Response body: " + response.body().string());
        } catch (IOException e) {
            System.out.println("Error executing request: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        OkHttpClientExample.getExample();
//        OkHttpClientExample.postExample();
    }
}
