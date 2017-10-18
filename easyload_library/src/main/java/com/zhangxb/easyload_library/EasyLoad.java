package com.zhangxb.easyload_library;

import android.content.Context;
import android.view.View;

import com.zhangxb.easyload_library.layout.AbstractLayout;

/**
 * Created by zhangxb on 2017/9/27.
 */

public class EasyLoad {
    TargetContext targetContext;

    /**
     * 绑定目标
     *
     * @param target
     */
    public void bind(Object target) {
        targetContext = ContextUtils.getTargetContext(target);
    }

    public void showLoading() {
        AbstractLayout loadLayout = EasyBuilder.getInstance().getLoadingLayout();
        replaceView(loadLayout);

    }

    public void showEmpty() {
        AbstractLayout loadLayout = EasyBuilder.getInstance().getEmptyLayout();
        replaceView(loadLayout);

    }

    public void showNetError() {
        AbstractLayout loadLayout = EasyBuilder.getInstance().getNetErrorLayout();
        replaceView(loadLayout);

    }

    public void showError() {
        AbstractLayout loadLayout = EasyBuilder.getInstance().getErrorLayout();
        replaceView(loadLayout);

    }

    public void showCustom() {
        AbstractLayout loadLayout = EasyBuilder.getInstance().getCustomLayout();
        replaceView(loadLayout);

    }

    public void showNormal() {
        View oldView = targetContext.getOldContent();
        replaceView(oldView);
    }

    private void replaceView(View loadLayout) {
        Context context = targetContext.getContext();
        View oldContent = targetContext.getOldContent();
        if (targetContext.getParentView() != null) {
            targetContext.getParentView().removeAllViews();
            targetContext.getParentView().addView(loadLayout, targetContext.getChildIndex(), oldContent.getLayoutParams());
        }
    }
}
