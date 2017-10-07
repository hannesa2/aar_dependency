package com.example.my.mylibrary;

import android.util.Base64;

public class AccessToken {

    private static AccessToken ourInstance;
    public String access_token;

    private AccessToken() {
    }

    public static AccessToken getInstance() {
        if (ourInstance == null) {
            ourInstance = new AccessToken();
        }
        return ourInstance;
    }

    public void setCredential(String username, String password) {
        String credentials = username + ":" + password;
        access_token = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
    }
}
