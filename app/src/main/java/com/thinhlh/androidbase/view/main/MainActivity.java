package com.thinhlh.androidbase.view.main;

import com.thinhlh.androidbase.R;
import com.thinhlh.androidbase.base.activity.BaseFragmentBindingActivity;
import com.thinhlh.androidbase.base.fragment.FragmentNavigator;
import com.thinhlh.androidbase.databinding.ActivityMainBinding;
import com.thinhlh.androidbase.view.home.HomeFragment;

/**
 * Created by thinhlh on 06/03/2022.
 * Copyright (c). All rights reserved
 */
public class MainActivity extends BaseFragmentBindingActivity<ActivityMainBinding, MainVM> implements MainUV {
    @Override
    protected Integer layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        getNavigator().setRootFragment(new HomeFragment());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initActions() {

    }

    @Override
    protected Class<MainVM> viewModelClass() {
        return MainVM.class;
    }

    @Override
    protected void initViewModel(MainVM viewModel) {
        viewModel.init(this);
    }

    @Override
    protected FragmentNavigator createFragmentNavigator() {
        return new FragmentNavigator(getSupportFragmentManager(), R.id.fragment_container_view_tag);
    }
}
