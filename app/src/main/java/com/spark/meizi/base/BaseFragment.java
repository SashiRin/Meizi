package com.spark.meizi.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Spark on 2016/7/10 23:21:24.
 */
public class BaseFragment<V, T extends BasePresenter<V>> extends Fragment implements IView, View.OnClickListener {

    protected T mPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LayoutInflater mInflater = LayoutInflater.from(getContext());
        mInflater = mInflater.cloneInContext(getContext());
        View containerView = mInflater.inflate(getContentViewId(), container, false);
        doInitPresenter();
        initSubViews(containerView);
        return containerView;
    }

    private void doInitPresenter() {
        if (mPresenter == null)
            mPresenter = doGetPresenter();
    }

    protected T doGetPresenter() {
        return null;
    }

    @Override
    public ViewGroup getViewGroupRoot() {
        return null;
    }

    @Override
    public int getContentViewId() {
        return 0;
    }

    @Override
    public void initSubViews(View view) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachViewRef();
        }
    }

}
