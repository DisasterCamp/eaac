package com.eaac.api;

import com.eaac.api.entity.User;


public interface SimplerApi {
    void sayHey(String message);

    String sayHello(String user,String message);

    User sayHello();
}
