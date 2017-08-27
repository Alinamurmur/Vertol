package com.example.alinamurmur.myprojektiswork;


import io.flowup.FlowUp;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FlowUp.Builder.with(this)
                .apiKey("d59ae22e3ab94a179235b0a84a9180ae")
                .forceReports(BuildConfig.DEBUG)
                .start();
    }
}
