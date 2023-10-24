package com.example.tablecrafters.services.impl;

import com.example.tablecrafters.services.RetrofitClient;
import com.example.tablecrafters.services.interfaces.ApiLogin;

//Esta clase llama a la API
public class ApiUtils {
    private ApiUtils() {}
    //public static final String BASE_URL = "http://10.2.50.247:8080/tableCrastersAPI-1/";
    public static final String BASE_URL = "http://10.2.50.247:8080/demo-1/";
    public static ApiLogin getApiLogin() {
        return RetrofitClient.getClient(BASE_URL).create(ApiLogin.class);
    }
}