package com.jialong.powersite;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class JlpowersiteApplicationTests {

    @Test
    void contextLoads() {
        String[] array = {"a","b","c"};
        List<String> resultList= new ArrayList<>(Arrays.asList(array));
        resultList.add("ff");
    }

}
