package com.lqm.tomatoit.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.lqm.tomatoit.R;
import com.lqm.tomatoit.ui.activity.AboutActivity;
import com.lqm.tomatoit.ui.activity.CollectActivity;
import com.lqm.tomatoit.ui.activity.LoginActivity;
import com.lqm.tomatoit.ui.base.BaseFragment;
import com.lqm.tomatoit.ui.base.BasePresenter;
import com.lqm.tomatoit.util.PrefUtils;
import com.lqm.tomatoit.util.T;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * user：lqm
 * desc：第三个模块，用户模块
 */

public class UserFragment extends BaseFragment {

    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.cv_collect)
    CardView cvCollect;
    @Bind(R.id.cv_about)
    CardView cvAbout;
    @Bind(R.id.cv_logou)
    CardView cvLogou;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.frag_user;
    }


    @OnClick({R.id.cv_collect, R.id.cv_about, R.id.cv_logou})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cv_collect:
                if (PrefUtils.getBoolean(getContext(),"isLogin",false) == false){
                    T.showShort(getContext(),"请先登录");
                }else{
                    startActivity(new Intent(getActivity(),CollectActivity.class));
                }
                break;
            case R.id.cv_about:
                startActivity(new Intent(getActivity(),AboutActivity.class));
                break;
            case R.id.cv_logou:
//                if (PrefUtils.getBoolean(getContext(),"isLogin",false) == false){
//
//
//                }else{
//
//                }
                startActivity(new Intent(getActivity(),LoginActivity.class));
                break;
        }
    }
}
