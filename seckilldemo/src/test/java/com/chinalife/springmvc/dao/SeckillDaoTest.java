package com.chinalife.springmvc.dao;

import com.chinalife.springmvc.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

/**
 * Created by chinalife on 2017/1/5.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillDaoTest {
    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int i=seckillDao.reduceNumber(1,killTime);
        System.out.println("i="+i);


    }

    @Test
    public void queryById() throws Exception {
        Seckill seckill = seckillDao.queryById(2);
        System.out.println(seckill.toString());

    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckillList = seckillDao.queryAll(1,4);
        for (Seckill seckill:seckillList) {
            System.out.println(seckill);
        }
    }

}