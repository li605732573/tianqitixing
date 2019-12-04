package com.lbx.tianqitixing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TianqitixingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TianqitixingApplication.class, args);
    }

}
