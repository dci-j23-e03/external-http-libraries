package com.dzenang;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;

public class ApacheHttpClientExample {

    public static void getExample() {
        try(CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://catfact.ninja/fact");
            CloseableHttpResponse response = client.execute(request);
            System.out.println("Status: " + response.getCode());
            HttpEntity entity = response.getEntity();
            System.out.println("Response body: " + EntityUtils.toString(entity));
        } catch (IOException e) {
            System.out.println("Error while creating http client: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error while parsing the response: " + e.getMessage());
        }
    }

    public static void postExample() {
        try(CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost("https://postman-echo.com/post");
            request.setHeader("Content-Type", "text/plain");
            request.setEntity(new StringEntity("Hello World"));

            CloseableHttpResponse response = client.execute(request);
            System.out.println("Status: " + response.getCode());
            HttpEntity entity = response.getEntity();
            System.out.println("Response body: " + EntityUtils.toString(entity));
        } catch (IOException e) {
            System.out.println("Error while creating http client: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Error while parsing the response: " + e.getMessage());
        }
    }
}
