package com.zhangxb.easyload_library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.zhangxb.easyload_library.layout.AbstractLayout;
import com.zhangxb.easyload_library.listener.OnReloadListener;

import java.util.Map;

/**
 * Created by zhangxb on 2017/9/27.
 */

public class EasyBuilder {
    private Context context;
    private AbstractLayout emptyLayout;
    private AbstractLayout loadingLayout;
    private AbstractLayout netErrorLayout;
    private AbstractLayout errorLayout;
    private AbstractLayout customLayout;

    private OnReloadListener onReloadListener;

    private static class SingelT {
        static EasyBuilder INSTANCE = new EasyBuilder();
    }

    public static EasyBuilder getInstance() {
        return SingelT.INSTANCE;
    }

    /**
     * 添加空布局
     *
     * @param abstractLayout
     * @return
     */
    public EasyBuilder addEmptyLayout(AbstractLayout abstractLayout) {
        addOperation(abstractLayout);
        emptyLayout = abstractLayout;
        emptyLayout.addView(LayoutInflater.from(abstractLayout.getContext()).inflate(abstractLayout.setLayout(), null, false));
        return this;
    }

    /**
     * 添加加载中布局
     *
     * @param abstractLayout
     * @return
     */
    public EasyBuilder addLoadingLayout(AbstractLayout abstractLayout) {
        addOperation(abstractLayout);
        loadingLayout = abstractLayout;
        loadingLayout.addView(LayoutInflater.from(abstractLayout.getContext()).inflate(abstractLayout.setLayout(), null, false));
        return this;
    }

    /**
     * 添加网络错误布局
     *
     * @param abstractLayout
     * @return
     */
    public EasyBuilder addNetErrorLayout(AbstractLayout abstractLayout) {
        addOperation(abstractLayout);
        netErrorLayout = abstractLayout;
        netErrorLayout.addView(LayoutInflater.from(abstractLayout.getContext()).inflate(abstractLayout.setLayout(), null, false));
        return this;
    }

    /**
     * 添加出错布局
     *
     * @param abstractLayout
     * @return
     */
    public EasyBuilder addErrorLayout(AbstractLayout abstractLayout) {
        addOperation(abstractLayout);
        errorLayout = abstractLayout;
        errorLayout.addView(LayoutInflater.from(abstractLayout.getContext()).inflate(abstractLayout.setLayout(), null, false));
        return this;
    }

    /**
     * 添加自定义布局
     *
     * @param abstractLayout
     * @return
     */
    public EasyBuilder addCustomLayout(AbstractLayout abstractLayout) {
        addOperation(abstractLayout);
        customLayout = abstractLayout;
        customLayout.addView(LayoutInflater.from(abstractLayout.getContext()).inflate(abstractLayout.setLayout(), null, false));
        return this;
    }

    private void addOperation(AbstractLayout abstractLayout) {
       abstractLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onReloadListener.onReload(v);
           }
       });
    }

    /**
     * 添加重试回调
     * @param onReloadListener
     * @return
     */
    public EasyBuilder addOnReloadListener(OnReloadListener onReloadListener){
        this.onReloadListener = onReloadListener;
        return this;
    }


    public EasyLoad build() {
        return new EasyLoad();
    }

    public EasyBuilder from(Context context) {
        this.context = context;
        return this;
    }


    public AbstractLayout getEmptyLayout() {
        return emptyLayout;
    }

    public AbstractLayout getLoadingLayout() {
        return loadingLayout;
    }

    public AbstractLayout getNetErrorLayout() {
        return netErrorLayout;
    }

    public AbstractLayout getErrorLayout() {
        return errorLayout;
    }

    public AbstractLayout getCustomLayout() {
        return customLayout;
    }
}
