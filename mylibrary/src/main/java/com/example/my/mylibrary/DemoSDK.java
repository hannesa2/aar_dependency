package com.example.my.mylibrary;

import android.app.Application;

import com.example.my.mylibrary.di.components.DemoComponent;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import javax.inject.Inject;

public class DemoSDK {

    private static Application application;
    private DemoComponent mGraph;
    @Inject
    DataManagerDemo mDataManagerDemo;

    public DemoSDK() {
        buildGraphAndInject();
    }

    public static void init(Application app) {
        application = app;
    }

    protected void buildGraphAndInject() {
        mGraph = DemoComponent.Initializer.init(application);
        mGraph.inject(this);
    }

    public void isBounded(String email) {
        mDataManagerDemo.isBound(email)
                .subscribe(new SingleObserver<Boolean>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(Boolean bounded) {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                });
    }

    public void bind(String email, String accessCode) {
        mDataManagerDemo.bind(email, accessCode)
                .subscribe(new MaybeObserver<String>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull String status) {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }

                });
    }

    public void unbind(String email) {
        mDataManagerDemo.unbind(email)
                .subscribe(new SingleObserver<String>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull String status) {
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                });
    }

    public String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

}
