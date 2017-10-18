package com.zhangxb.easyload_library;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhangxb on 2017/9/27.
 */

public class ContextUtils {

    /**
     * 根绝传入的绑定目标，获取目标的一些view属性
     *
     * @param target
     * @return
     */
    public static TargetContext getTargetContext(Object target) {
        Context context;
        ViewGroup parentView;
        View oldContent;
        int childIndex = 0;

        if(target instanceof Activity){
            Activity activity = (Activity) target;
            context = activity;
            //获取根view
            parentView = (ViewGroup) activity.findViewById(android.R.id.content);
        }else if(target instanceof View){
            View view = (View) target;
            parentView = (ViewGroup) (view.getParent());
            context = view.getContext();
        }else {
            throw new IllegalArgumentException("绑定控件不正确，请确认是否是activity, fragment或者view");
        }

        int childCount = parentView == null ? 0 : parentView.getChildCount();
        if (target instanceof View) {
            oldContent = (View) target;
            for (int i = 0; i < childCount; i++) {
                if (parentView.getChildAt(i) == oldContent) {
                    childIndex = i;
                    break;
                }
            }
        } else {
            oldContent = parentView != null ? parentView.getChildAt(0) : null;
        }
        if (oldContent == null) {
            throw new IllegalArgumentException(String.format("enexpected error when register LoadSir in %s", target
                    .getClass().getSimpleName()));
        }

        return new TargetContext(context, parentView, oldContent, childIndex);
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

}
