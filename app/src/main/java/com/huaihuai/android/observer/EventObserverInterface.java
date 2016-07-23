package com.huaihuai.android.observer;

/**
 * @author wangduo
 * @description: 观察者接口
 * @email: cswangduo@163.com
 * @date: 16/7/23
 */
public interface EventObserverInterface {

    /**
     * 根据事件进行数据或者UI的更新
     *
     * @param eventType
     */
    void dispatchChange(String eventType);

}
