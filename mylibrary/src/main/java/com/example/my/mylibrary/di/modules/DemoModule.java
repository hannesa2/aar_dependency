package com.example.my.mylibrary.di.modules;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.my.mylibrary.ApiClient;
import com.example.my.mylibrary.DataManagerDemo;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;


@Module
public class DemoModule {

    private final Context context;

    public DemoModule(@NonNull Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public ApiClient provideApiClient() {
        return new ApiClient();
    }

    @Provides
    @Singleton
    public DataManagerDemo provideDataManager(ApiClient apiClient) {
        return new DataManagerDemo(apiClient);
    }

}
