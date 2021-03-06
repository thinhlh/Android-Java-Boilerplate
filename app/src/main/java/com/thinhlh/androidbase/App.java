package com.thinhlh.androidbase;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LifecycleObserver;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.Logger;
import com.thinhlh.utils.helper.AppPreferences;
import com.thinhlh.utils.helper.NotificationUtils;

import java.util.prefs.Preferences;


/**
 * Created by thinhlh on 02/03/2022.
 * Copyright (c). All rights reserved
 */
public class App extends Application implements LifecycleObserver {

    private static Context appContext;
    private static final String PACKAGE_NAME = BuildConfig.APPLICATION_ID;
    private static final String CHANNEL_ID = PACKAGE_NAME + ".channelId";
    private static final String CHANNEL_NAME = PACKAGE_NAME + ".channelName";

    public static Context getAppContext() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;

        initServices();

    }

    private void initServices() {
        // Init logger
        Logger.addLogAdapter(new AndroidLogAdapter());

        // Disable Firebase Crashlytics in DEBUG mode
        if (BuildConfig.DEBUG) {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(false);
        }

        // Init notification utils
        NotificationUtils.createNotificationChannel(this, CHANNEL_ID, CHANNEL_NAME);

        // Init Shared Preferences
        AppPreferences.get().init(this);
    }
}
