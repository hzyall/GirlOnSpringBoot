package com.hzy.girl;

import com.hzy.girl.model.GiftModel;
import com.hzy.girl.service.GirlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Timestamp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {

    @Autowired
    private GirlService girlService;

    @Test
    public void contextLoads() {
        GiftModel giftModel = new GiftModel();
        giftModel.setGiftName("car");
        giftModel.setGiftValue(new BigDecimal(100));
        giftModel.setId("123123123");
        giftModel.setInitiator("audience");
        giftModel.setTarget("anchorA");
        girlService.methodA(giftModel);
    }


}
