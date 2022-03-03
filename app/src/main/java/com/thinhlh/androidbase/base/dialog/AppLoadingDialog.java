package com.thinhlh.androidbase.base.dialog;

import android.app.AlertDialog;
import android.view.LayoutInflater;

import androidx.databinding.DataBindingUtil;

import com.thinhlh.androidbase.R;
import com.thinhlh.androidbase.databinding.DialogLoadingBinding;
import com.thinhlh.utils.helper.AppPreferences;

import kotlin.jvm.Volatile;

/**
 * Created by thinhlh on 02/03/2022.
 * Copyright (c). All rights reserved
 */
public class AppLoadingDialog extends BaseDialog {

    // Singleton
    private AppLoadingDialog() {
    }

    private static volatile AppLoadingDialog instance;

    public static synchronized AppLoadingDialog get() {
        if (instance == null) {
            instance = new AppLoadingDialog();
        }

        return instance;
    }

    /**
     * Show loading dialog
     */
    void show() {
        if (context == null) return;
        final DialogLoadingBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.dialog_loading,
                null,
                true
        );

        dialog = new AlertDialog.Builder(context,R.style.Base_MaterialAlerDialog)
    }

}
