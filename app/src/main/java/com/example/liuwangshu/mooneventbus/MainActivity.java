package com.example.liuwangshu.mooneventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private TextView tv_message;

    private Button bt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_message = (TextView) this.findViewById(R.id.tv_message);
        tv_message.setText("MainActivity");

        bt_message = (Button) this.findViewById(R.id.bt_message);
        bt_message.setText("跳转到SecondActivity");

        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        // 第二步：注册事件
        EventBus.getDefault().register(MainActivity.this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 取消注册事件
        EventBus.getDefault().unregister(this);
    }

    /** 处理 MAIN事件 **/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent) {
        tv_message.setText(messageEvent.getMessage());
    }

    /** 处理 粘性事件 **/
    @Subscribe(sticky = true)
    public void ononMoonStickyEvent(MessageEvent messageEvent) {
        tv_message.setText(messageEvent.getMessage());
    }
}
