package com.thinhlh.androidbase.base.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import com.thinhlh.androidbase.base.viewmodel.BaseViewModel;
import com.thinhlh.utils.constants.Const;

/**
 * Created by thinhlh on 02/03/2022.
 * Copyright (c). All rights reserved
 */
public abstract class BaseFullscreenActivity<T extends ViewDataBinding, VM extends BaseViewModel> extends BaseActivity<T, VM> {
    private final Boolean runInFullScreen = Const.RUN_IN_FULL_SCREEN;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        if (runInFullScreen) {
            if (getWindow().getDecorView() != null) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
            }
        }

        super.onCreate(savedInstanceState);
    }
}
