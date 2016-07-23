package com.huaihuai.android.observer;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author wangduo
 * @description: ${todo}
 * @email: cswangduo@163.com
 * @date: 16/7/23
 */
public class EventSubject implements EventSubjectInterface {

    private static final String TAG = "EventSubject";
    private HashMap<String, ArrayList<EventObserver>> mEventObservers = new HashMap<>();

    private EventSubject() {
    }

    private static class Holder {
        private static EventSubject instance = new EventSubject();
    }

    public static EventSubject getInstance() {
        return Holder.instance;
    }

    @Override
    public void registerObserver(String eventType, EventObserver observer) {
        synchronized (mEventObservers) {
            ArrayList<EventObserver> eventObservers = mEventObservers.get(eventType);
            if (eventObservers == null) {
                eventObservers = new ArrayList<>();
                mEventObservers.put(eventType, eventObservers);
            }
            if (eventObservers.contains(observer)) {
                return;
            }
            eventObservers.add(observer);
        }
    }

    @Override
    public void unRegisterObserver(String eventType, EventObserver observer) {
        synchronized (mEventObservers) {
            int index = mEventObservers.get(eventType).indexOf(observer);
            if (index >= 0) {
                mEventObservers.get(eventType).remove(observer);
            }
        }
    }

    @Override
    public void notifyObserver(String eventType) {
        if (mEventObservers != null && mEventObservers.size() > 0 && eventType != null) {
            ArrayList<EventObserver> eventObservers = mEventObservers.get(eventType);
            if (eventObservers != null) {
                for (EventObserver observer : eventObservers) {
                    observer.dispatchChange(eventType);
                }
            } else {
                Log.e(TAG, "eventObservers is null," + eventType + " may be not register");
            }
        }

    }

}
