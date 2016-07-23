package com.huaihuai.android.observer;

/**
 * @author wangduo
 * @description: 通知中心，用来通知更新数据或者UI，采用单例模式
 * @email: cswangduo@163.com
 * @date: 16/7/23
 */
public class Notify {

    private static volatile Notify mNotify;

    private Notify() {
    }

    public static Notify getInstance() {
        if (mNotify == null) {
            mNotify = new Notify();
        }
        return mNotify;
    }

    public void NotifyActivity(String eventType) {
        EventSubject eventSubject = EventSubject.getInstance();
        EventType eventTypes = EventType.getInstance();
        if (eventTypes.contains(eventType)) {
            eventSubject.notifyObserver(eventType);
        }
    }

}
