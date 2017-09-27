package com.zhangxb.easyload_library.layout;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxb on 2017/9/27.
 */

public abstract class AbstractLayout {
    private Map<Integer, View.OnClickListener> operations;

    public abstract int setLayout();

    public void addOperationListener(int id, View.OnClickListener clickListener){
        operations.put(id, clickListener);
    }

    public AbstractLayout() {
        operations = new HashMap<>();
    }

    public Map<Integer, View.OnClickListener> getOperations(){
        return operations;
    }
}
