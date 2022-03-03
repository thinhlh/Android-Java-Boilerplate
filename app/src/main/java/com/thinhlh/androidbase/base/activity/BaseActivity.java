package com.thinhlh.androidbase.base.activity;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelProvider;

import com.thinhlh.androidbase.base.viewmodel.BaseViewModel;
import com.thinhlh.androidbase.base.viewmodel.ViewState;

import kotlin.coroutines.CoroutineContext;

/**
 * Created by thinhlh on 02/03/2022.
 * Copyright (c). All rights reserved
 */
public abstract class BaseActivity<T extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements LifecycleObserver {

    protected Context context;

    protected T binding;

    @LayoutRes
    protected abstract Integer layoutRes();

    // Logic functions

    /**
     * Setup the properties of view
     */
    protected abstract void initView();

    /**
     * Setup data binding values, view model values...
     */
    protected abstract void initData();

    /**
     * Setup listener...
     */
    protected abstract void initActions();

    // View model setup
    protected VM viewModel;

    protected abstract Class<VM> viewModelClass();

    protected abstract void initViewModel(VM viewModel);

    // Dialog

    // Keyboard
    public void onKeyboardVisibilityListener(boolean isShow) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;

        // Add Lifecycle observer to the activity
        getLifecycle().addObserver(this);

        // DataBinding setup
        binding = DataBindingUtil.setContentView(this, layoutRes());
        binding.setLifecycleOwner(this);

        // View Model setup
        viewModel = new ViewModelProvider(this).get(viewModelClass());

        // Run the initialization of view model then observe the view state
        initViewModel(viewModel);

        viewModel.getViewState().observe(this, viewState -> {

            if (viewState.equals(ViewState.SHOW_LOADING)) {
                showLoading(true);

            } else if (viewState.equals(ViewState.HIDE_LOADING)) {
                showLoading(false);

            } else if (viewState.equals(ViewState.SHOW_ERROR)) {
                if (viewModel.errorMessage != null) {
                    showError(viewModel.errorMessage);
                }
            }
        });

        // Run initializations
        initView();
        initData();
        initActions();
    }

    @Override
    protected void onStart() {

        // Init loading dialogs here
        super.onStart();
    }

    /**
     * Hide keyboard when click outside EditText
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            try {
                final View currentFocus = getCurrentFocus();

                if (currentFocus instanceof EditText) {
                    final Rect outRect = new Rect();

                    currentFocus.getGlobalVisibleRect(outRect);
                }
            } catch (Exception e) {

            }
        }

        return super.dispatchTouchEvent(ev);
    }

    private void showLoading(Boolean show) {
        dismissLoading();

        if (show) {
            new Handler().postDelayed(() -> {
                // AppLoadingDialog.get().show();
            }, 100L);
        }
    }

    private void dismissLoading() {

    }
}
