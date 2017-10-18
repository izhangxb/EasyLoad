package com.zhangxb.easyload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhangxb.easyload.layout.LoadingLayout;
import com.zhangxb.easyload.layout.NetErrorLayout;
import com.zhangxb.easyload_library.EasyBuilder;
import com.zhangxb.easyload_library.EasyLoad;
import com.zhangxb.easyload_library.listener.OnReloadListener;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EasyBuilder.getInstance().addLoadingLayout(new LoadingLayout(this))
        .addNetErrorLayout(new NetErrorLayout(this))
        .addOnReloadListener(new OnReloadListener() {
            @Override
            public void onReload(View view) {
                Log.d("TAG", "onreload");
            }
        });

        final EasyLoad easyLoad = EasyBuilder.getInstance().build();
        easyLoad.bind(this);


        button = (Button) findViewById(R.id.btn_click);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easyLoad.showLoading();
            }
        });


    }
}
