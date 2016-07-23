package com.huaihuai.android.observer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wangduo
 * @description: 所有的业务类型，在这里写，方便管理
 * @email: cswangduo@163.com
 * @date: 16/7/23
 */
public class EventType {

    private static volatile EventType mEventType;
    private final static Set<String> eventsTypes = new HashSet<String>();

    public final static String UPDATE_MAIN = "com.updateMain";
    public final static String UPDATE_Text = "com.updateText";

    private EventType() {
        eventsTypes.add(UPDATE_MAIN);
        eventsTypes.add(UPDATE_Text);
    }

    public static EventType getInstance() {
        if (mEventType == null) {
            mEventType = new EventType();
        }
        return mEventType;
    }

    public boolean contains(String eventType) {
        return eventsTypes.contains(eventType);
    }

}
