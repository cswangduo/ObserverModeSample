package com.huaihuai.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huaihuai.android.observer.BaseObserverActivity;
import com.huaihuai.android.observer.EventType;
import com.huaihuai.android.R;

public class MainActivity extends BaseObserverActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), OtherActivity.class));
            }
        });
    }

    @Override
    protected void onChange(String eventType) {
        if (EventType.UPDATE_MAIN == eventType) {
            ((TextView) findViewById(R.id.tv_content1)).setText("UPDATE_MAIN");
        } else if (EventType.UPDATE_Text == eventType) {
            ((TextView) findViewById(R.id.tv_content2)).setText("UPDATE_Text");
        }
    }

    @Override
    protected String[] getObserverEventType() {
        return new String[]{
                EventType.UPDATE_MAIN,
                EventType.UPDATE_Text
        };
    }

}
