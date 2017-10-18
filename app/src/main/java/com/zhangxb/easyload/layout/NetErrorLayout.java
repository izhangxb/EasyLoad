package com.zhangxb.easyload.layout;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.zhangxb.easyload.R;
import com.zhangxb.easyload_library.layout.AbstractLayout;

/**
 * -------------------------------
 * -         ,.                  -
 * -        (_|,.                -
 * -       ,' /, )_______   _    -
 * -    __j o``-'        `.'-)'  -
 * -   (")                 \'    -
 * -    `-j                |     -   神兽保佑，永无BUG
 * -      `-._(           /      -
 * -         |_\  |--^.  /       -
 * -        /_]'|_| /_)_/        -
 * -           /_]'  /_]'        -
 * -------------------------------
 *
 * @Description: .
 * @Date: 2017/10/18.
 * @Author: zhangxb.
 */

public class NetErrorLayout extends AbstractLayout {
    public NetErrorLayout(@NonNull Context context) {
        super(context);
    }

    public NetErrorLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NetErrorLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int setLayout() {
        return R.layout.layout_error;
    }
}
