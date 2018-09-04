package com.hzy.girl.reponsitory;

import com.hzy.girl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlReponsitory extends JpaRepository<Girl, Integer> {

    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
