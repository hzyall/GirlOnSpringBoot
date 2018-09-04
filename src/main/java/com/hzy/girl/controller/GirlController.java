package com.hzy.girl.controller;

import com.hzy.girl.entity.Girl;
import com.hzy.girl.reponsitory.GirlReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {


    @Autowired
    private GirlReponsitory girlReponsitory;

    /**
     * 查询女生列表
     * @return
     */
    @GetMapping(value = "girls")
    public List<Girl> girlList() {
        return girlReponsitory.findAll();
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        System.out.println(girl);
        return girlReponsitory.save(girl);
    }

    /**
     * 根据ID查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        Optional<Girl> result = girlReponsitory.findById(id);
        if (result == null)
            return null;
        return result.get();
    }

    @PutMapping(value = "/girls/{id}")
    public Girl GirlUpdate(@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlReponsitory.save(girl);
    }


    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlReponsitory.deleteById(id);
    }

    /**
     * 通过年龄查询列表
     * @param age
     * @return
     */
    @GetMapping(value = "/girl/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age) {
        List<Girl> girls = girlReponsitory.findByAge(age);
        return girls;
    }
}
