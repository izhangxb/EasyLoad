package com.zhangxb.easyload_library;

import android.app.Activity;
import android.content.Context;
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
        int childIndex;

        if(target instanceof Activity){
            Activity activity = (Activity) target;
            context = activity;
            //获取根view
            parentView = (ViewGroup) activity.findViewById(android.R.id.content);
        }else if(target instanceof View){

        }else {
            throw new IllegalArgumentException("绑定控件不正确，请确认是否是activity, fragment或者view");
        }
        return new TargetContext(context, parentView, oldContent, childIndex);
    }
}
