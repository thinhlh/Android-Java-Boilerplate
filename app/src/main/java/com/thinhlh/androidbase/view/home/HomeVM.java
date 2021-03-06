package com.thinhlh.androidbase.view.home;

import com.thinhlh.androidbase.base.viewmodel.BaseRepoViewModel;
import com.thinhlh.domain.api.base.BaseResponse;
import com.thinhlh.domain.repository.base.BaseRepoCallback;
import com.thinhlh.domain.repository.common.CommonRepo;

public class HomeVM extends BaseRepoViewModel<CommonRepo, HomeUV> {
    public void onTextClicked() {
        uiCallback.updateData("");
//        getRepo().ping(new BaseRepoCallback<BaseResponse<String>>() {
//
//            @Override
//            public void apiRequesting(Boolean show) {
//                showLoading(show);
//            }
//
//            @Override
//            public void apiResponse(BaseResponse<String> data) {
//                uiCallback.updateData(data.getData());
//            }
//        });
    }

    @Override
    protected CommonRepo createRepo() {
        return new CommonRepo();
    }
}
