package org.example.self_introduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SelfIntroductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelfIntroductionApplication.class, args);
    }

}
