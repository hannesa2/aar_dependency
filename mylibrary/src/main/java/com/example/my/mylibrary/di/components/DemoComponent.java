package com.example.my.mylibrary.di.components;

import android.app.Application;
import android.content.Context;

import com.example.my.mylibrary.ApiClient;
import com.example.my.mylibrary.DataManagerDemo;
import com.example.my.mylibrary.DemoSDK;
import com.example.my.mylibrary.di.modules.DemoModule;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = DemoModule.class)
public interface DemoComponent {

    void inject(DemoSDK demoSDK);

    Context appContext();

    @Singleton
    DataManagerDemo DataManager();

    @Singleton
    ApiClient ApiClient();

    final class Initializer {
        private Initializer() {
        }

        public static DemoComponent init(Application app) {
            return DaggerDemoComponent.builder()
                    .demoModule(new DemoModule(app))
                    .build();
        }
    }
}
