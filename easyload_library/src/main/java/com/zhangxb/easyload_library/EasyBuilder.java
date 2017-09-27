package com.zhangxb.easyload_library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.zhangxb.easyload_library.layout.AbstractLayout;

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
        return this;
    }

    private void addOperation(AbstractLayout abstractLayout) {
        //获取布局
        int viewId = abstractLayout.setLayout();
        View view = LayoutInflater.from(context).inflate(viewId, null);
        //获取布局上的操作，并设置对应动作
        Map<Integer, View.OnClickListener> opera = abstractLayout.getOperations();
        for (Map.Entry<Integer, View.OnClickListener> entry : opera.entrySet()) {
            view.findViewById(entry.getKey()).setOnClickListener(entry.getValue());
        }
    }

    public EasyLoad build() {
        return new EasyLoad();
    }

    public EasyBuilder from(Context context) {
        this.context = context;
        return this;
    }


}
