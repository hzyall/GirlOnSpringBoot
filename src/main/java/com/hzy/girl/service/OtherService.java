package com.hzy.girl.service;

import com.hzy.girl.entity.Girl;
import com.hzy.girl.reponsitory.GirlReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OtherService {

    @Autowired
    private GirlReponsitory girlReponsitory;

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
    public void methodB(){
        Girl girl = new Girl();
        girl.setAge(1000);
        girl.setCupSize("G");
        girlReponsitory.save(girl);
    }

//    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NESTED)
//    public void methodB(){
//        Girl girl = new Girl();
//        girl.setAge(1000);
//        girl.setCupSize("G");
//        girlReponsitory.save(girl);
//    }
}
