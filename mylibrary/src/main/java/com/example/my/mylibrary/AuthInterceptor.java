package com.example.my.mylibrary;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AuthInterceptor implements Interceptor {

    private static final String AUTHORIZATION = "Authorization";
    public AccessToken access;

    public AuthInterceptor(AccessToken access) {
        this.access = access;
    }

    public static Request addAuthorizationHeader(Request request, AccessToken access) {
        // Add authorization header with updated authorization value to intercepted request
        return request.newBuilder()
                .header(AUTHORIZATION, "Basic " + access.access_token)
                .build();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (access.access_token == null) {
            return chain.proceed(chain.request());
        }
        Request originalRequest = chain.request();

        return chain.proceed(addAuthorizationHeader(originalRequest, access));
    }
}
