package com.hzy.girl;

import com.hzy.girl.service.GirlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {

    @Autowired
    private GirlService girlService;

    @Test
    public void contextLoads() {
        girlService.methodA();
    }

}
