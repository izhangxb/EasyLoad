package com.zhangxb.easyload_library.layout;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxb on 2017/9/27.
 */

public abstract class AbstractLayout extends FrameLayout {

    public AbstractLayout(@NonNull Context context) {
        super(context);
    }

    public AbstractLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public abstract int setLayout();
}
