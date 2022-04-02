package com.longder.kindergarten.repository;


import com.longder.kindergarten.BaseSpringBootTest;
import com.longder.kindergarten.entity.enumeration.Gender;
import com.longder.kindergarten.entity.po.Child;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * 娃娃表操作测试
 */
public class ChildRepositoryTest extends BaseSpringBootTest {

    /**
     * 注入
     */
    @Resource
    private ChildRepository childRepository;

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<Child> childList = childRepository.findAll();
        // 断言判断
        Assertions.assertNotNull(childList);
    }

    /**
     * 测试添加
     */
    @Test
    public void testAdd(){
        Child child = new Child();
        child.setName("小红");
        child.setAge(5);
        child.setGender(Gender.FEMALE);
        child.setEmergencyContact("大红");
        child.setEmergencyMobile("13522324555");
        child = childRepository.save(child);
        Assertions.assertNotNull(child.getId());
    }
}
