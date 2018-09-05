package com.hzy.girl.service;

import com.hzy.girl.entity.Girl;
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

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    public void methodA(){
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
