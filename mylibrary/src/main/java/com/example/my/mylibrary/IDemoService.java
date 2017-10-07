package com.example.my.mylibrary;

import io.reactivex.Maybe;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IDemoService {

    @GET("/com/demo_integration/api/accountstatus")
    Single<String> isBounded(
            @Query("email") String email
    );

    @GET("/com/demo_integration/api/unbind")
    Single<String> unbind(
            @Query("email") String email
    );

    @GET("/com/demo_integration/api/bind")
    Maybe<String> bind(
            @Query("email") String email,
            @Query("authcode") String authCode
    );

    @GET("/com/demo_integration/api/gettoken")
    Maybe<String> getToken(
            @Query("email") String email
    );

    @POST("/com/demo_integration/api/getauthcode")
    Maybe<String> getAuthCode(
            @Query("email") String email
    );

}
