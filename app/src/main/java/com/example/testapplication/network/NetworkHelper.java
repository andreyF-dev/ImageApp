package com.example.testapplication.network;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.testapplication.R;
import com.example.testapplication.application.ImagesListApp;
import com.example.testapplication.description.Network;
import com.example.testapplication.network.handler.NetworkCallback;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class NetworkHelper {

    public void downloadImages(final NetworkCallback<List<String>> callback) {
        RequestQueue queue = Volley.newRequestQueue(ImagesListApp.getContext());
        String url = Network.IMAGES_URL;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            callback.onSuccess(formatJsonToStringsList(response));
                        } catch (Exception e){
                            callback.onError(R.string.parse_error);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError(R.string.network_error);
            }
        });
        queue.add(stringRequest);
    }

    private List<String> formatJsonToStringsList(String response) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();
        return gson.fromJson(response, listType);
    }
}
