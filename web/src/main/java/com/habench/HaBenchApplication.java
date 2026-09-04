package com.habench;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** PoC 驱动的宿主应用：把所有用例的 controller 挂上，供动态验证访问。 */
@SpringBootApplication(scanBasePackages = "com.habench")
public class HaBenchApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaBenchApplication.class, args);
    }
}
