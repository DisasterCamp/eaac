## 🔥Features
- 🚀 Out of the box
- 🍄 High scalability
- 🔆 High performance
- ..........（To be continued）
## 🖥 Environment Required
- jdk 1.8+
- ......

## 🌎 Architecture

....（To be continued）

## ☀️ Quick Start

### 💊 Dependency
#### java、spring
```java 
<dependency>
       <groupId>love.disaster</groupId>
       <artifactId>eaac-core</artifactId>
       <version>1.1.0</version>
</dependency>
```
#### springboot
```java 
<dependency>
       <groupId>love.disaster</groupId>
       <artifactId>eaac-springboot-starter</artifactId>
       <version>1.1.0</version>
</dependency>
```
### 🛁 USE
#### java primitive
1.Annotate the mapping classes that the eaac needs to process
```java
@StatementMapperClazz(appIds = {"app1", "app2"},invokerType = "http")
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
```
2.Use the eaac to call the api
```java
EcConfiguration ecConfiguration =  new EcConfiguration(new String[]{"http"},new String[]{"com.eaac"});
SimpleExecutor simpleExecutor = new SimpleExecutor(ecConfiguration);
Object exec = simpleExecutor.exec("http", "app1", "hh", "hello world");
```
#### springboot

##### 1.Configuration

```yaml
eaac:
  config: 
    scanPackage: "com.eaac"
    supportType: "http"
```
##### 2.Using

###### 1.Programmatic use
1.Annotate the mapping classes that the eaac needs to process
```java
@StatementMapperClazz(appIds = {"app1", "app2"},invokerType = "http")
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
```

2.Just DI Executor into the class to use

```java
@SpringBootApplication
public class EaaCApplication {
    @Autowired
    private Executor executor;

    public static void main(String[] args) {
        SpringApplication.run(EaaCApplication.class, args);
    }
    

    @Bean
    public ApplicationRunner applicationRunner(){
        return args -> {
            simpleExecutor.exec("http", "app1", "hh", "hello world");
        };
    }
}
```

