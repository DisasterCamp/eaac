package com.eaac.config;

import com.eaac.BaseTest;
import com.eaac.exec.SimpleExecutor;
import org.junit.Test;

public class EcContainerTest extends BaseTest {

    @Test
    public void start() throws Exception{
        SimpleExecutor simpleExecutor = new SimpleExecutor(ecConfiguration);
        Object exec = simpleExecutor.exec("http", "app1", "hh", "hello world");
//        for (int i = 0; i < 1000 ; i++) {
//            new Thread(() -> {
//                try {
//                    Object exec = simpleExecutor.exec("http", "app1", "hh", "hello world");
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }).start();
//        }
//        Thread.sleep(2000000);
    }

}
