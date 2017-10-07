package com.example.my.mylibrary;

public class ApiClient {

    private static IDemoService sIDemoService;

    public ApiClient() {
        sIDemoService = getInternalPunkteCouchService();
    }

    private static IDemoService getInternalPunkteCouchService() {

        return ServiceCreationHelper.createAuthenticatedService(
                IDemoService.class,
                "https://somewhere",
                new AuthInterceptor(AccessToken.getInstance()));
    }

    public IDemoService getDemoService() {
        return sIDemoService;
    }

    public void setCredential(String user, String pass) {
        AccessToken.getInstance().setCredential(user, pass);
    }

}
