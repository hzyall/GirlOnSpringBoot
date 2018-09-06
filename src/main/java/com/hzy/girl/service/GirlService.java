package com.hzy.girl.service;

import com.hzy.girl.aop.Aspect4Log;
import com.hzy.girl.entity.Girl;
import com.hzy.girl.model.GiftModel;
import com.hzy.girl.reponsitory.GirlReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GirlService {

    @Autowired
    private GirlReponsitory girlReponsitory;

    @Autowired
    private OtherService otherService;

    @Aspect4Log(description = "this is just a test")
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void methodA(GiftModel giftModel){
        Girl girl = new Girl();
        girl.setAge(23);
        girl.setCupSize("F");
        girlReponsitory.save(girl);
        try {
            otherService.methodB();
        } catch (Exception e) {
            System.out.println("122222222222222222222222222222222");
        }
        Girl girl1 = new Girl();
        girl1.setAge(22);
        girl1.setCupSize("FF");
        girlReponsitory.save(girl1);
    }

}
