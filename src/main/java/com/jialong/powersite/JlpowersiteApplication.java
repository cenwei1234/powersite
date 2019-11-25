package com.jialong.powersite;

import com.jialong.powersite.core.utils.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jialong.powersite.modular.system.mapper")
public class JlpowersiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(JlpowersiteApplication.class, args);
    }

}
