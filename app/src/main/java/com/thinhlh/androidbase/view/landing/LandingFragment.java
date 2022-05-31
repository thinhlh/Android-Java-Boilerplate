package com.thinhlh.androidbase.view.landing;

import com.thinhlh.androidbase.R;
import com.thinhlh.androidbase.base.activity.BaseFragmentBindingActivity;
import com.thinhlh.androidbase.base.fragment.BaseFragment;
import com.thinhlh.androidbase.databinding.FragmentLandingBinding;

public class LandingFragment extends BaseFragment<FragmentLandingBinding, LandingVM> implements LandingUV {
    @Override
    protected Integer layoutRes() {
        return R.layout.fragment_landing;
    }

    @Override
    protected Class<LandingVM> viewModelClass() {
        return LandingVM.class;
    }

    @Override
    protected void initViewModel(LandingVM viewModel) {
        viewModel.init(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initAction() {

    }
}
