package com.huaihuai.android.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.huaihuai.android.R;
import com.huaihuai.android.observer.EventType;
import com.huaihuai.android.observer.Notify;

/**
 * @author wangduo
 * @description: ${todo}
 * @email: cswangduo@163.com
 * @date: 16/7/23
 */
public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notify.getInstance().NotifyActivity(EventType.UPDATE_Text);
                Notify.getInstance().NotifyActivity(EventType.UPDATE_MAIN);
            }
        });
    }

}
