package com.example.my.mylibrary;

import io.reactivex.Maybe;
import io.reactivex.MaybeTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;

public class DataManagerDemo {

    // TODO we should help the partner and prevent him to apply that much numbers. eg a config-file ?
    public static final String PARTNER_SHORTNAME = "lp484";
    public static final String ACCOUNTBINDING_CONSUMER = "109";
    public static final String CONSUMER = "118";
    public static final String CONSUMER_SECRET = "914%vWjAPa+m$e!Q";
    public static final String CONSUMER_AUTH_USER = "puc_mi_de";
    public static final String CONSUMER_AUTH_PASS = "O1agWxK8jervRXhL";
    private static final String PUNKTECOUCH_BASE_USER = "shop";
    private static final String PUNKTECOUCH_BASE_PASS = "sXU7iwaXJiGaGJ2AzijN";
    public static final String PUNKTECOUCH_URL =
            "https://" + PUNKTECOUCH_BASE_USER + ":" + PUNKTECOUCH_BASE_PASS + "@dev.punktecouch.de/de/customer/account/create/";

    private final ApiClient apiClient;

    @Inject
    public DataManagerDemo(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    protected <T> ObservableTransformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    protected <T> SingleTransformer<T, T> applySingleSchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    protected <T> MaybeTransformer<T, T> applyMaybeSchedulers() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Boolean> isBound(String email) {

        apiClient.setCredential(PUNKTECOUCH_BASE_USER, PUNKTECOUCH_BASE_PASS);

        return apiClient.getDemoService().isBounded(email)
                .map(Boolean::new)
                .flatMap(bounded -> Single.just(bounded))
                .compose(applySingleSchedulers());
    }

    public Single<String> unbind(String email) {

        apiClient.setCredential(PUNKTECOUCH_BASE_USER, PUNKTECOUCH_BASE_PASS);

        return apiClient.getDemoService().unbind(email)
                .map(String::new)
                .flatMap(bounded -> Single.just(bounded))
                .compose(applySingleSchedulers());
    }

    public Maybe<String> bind(String email, String accessCode) {

        apiClient.setCredential(PUNKTECOUCH_BASE_USER, PUNKTECOUCH_BASE_PASS);

        return apiClient.getDemoService().bind(email, accessCode)
                //                .map(String::new)
                .flatMap(bounded -> Maybe.just(bounded))
                .compose(applyMaybeSchedulers());
    }

    public Maybe<String> getToken(String email) {

        apiClient.setCredential(PUNKTECOUCH_BASE_USER, PUNKTECOUCH_BASE_PASS);

        return apiClient.getDemoService().getToken(email)
                .flatMap(bounded -> Maybe.just(bounded))
                .compose(applyMaybeSchedulers());
    }

    public Maybe<String> getAuthCode(String email) {

        apiClient.setCredential(PUNKTECOUCH_BASE_USER, PUNKTECOUCH_BASE_PASS);

        return apiClient.getDemoService().getAuthCode(email)
                .flatMap(bounded -> Maybe.just(bounded))
                .compose(applyMaybeSchedulers());
    }

}
