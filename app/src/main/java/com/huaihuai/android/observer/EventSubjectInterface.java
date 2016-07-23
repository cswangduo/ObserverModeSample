package com.huaihuai.android.observer;

/**
 * @author wangduo
 * @description: 抽象的主题角色
 * @email: cswangduo@163.com
 * @date: 16/7/23
 */
public interface EventSubjectInterface {

    /**
     * 注册观察者
     *
     * @param observer
     */
    void registerObserver(String eventType, EventObserver observer);

    /**
     * 反注册观察者
     *
     * @param observer
     */
    void unRegisterObserver(String eventType, EventObserver observer);

    /**
     * 通知注册的观察者进行数据或者UI的更新
     */
    void notifyObserver(String eventType);

}
