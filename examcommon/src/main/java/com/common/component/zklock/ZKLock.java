package com.common.component.zklock;

/**
 * @author ：zuo
 **/
public interface ZKLock {

    boolean lock(String lockpath);

    boolean unlock(String lockpath);

}
