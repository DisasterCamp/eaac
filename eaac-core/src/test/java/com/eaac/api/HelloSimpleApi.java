package com.eaac.api;

import com.eaac.api.entity.User;


@StatementMapperClazz(appIds = {"app1", "app2"})
public class HelloSimpleApi implements SimplerApi {
    @Override
    @StatementMapperMethod(uri = "hh")
    public void sayHey(String message) {
        System.out.println("message = " + message);
    }

    @Override
    @StatementMapperMethod(uri = "hh1")
    public String sayHello(String user, String message) {
        return user + ": " + message;
    }

    @Override
    public User sayHello() {
        User user = new User();
        user.setName("disaster1");
        user.setAge(18);
        return user;
    }
}
