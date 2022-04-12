package com.longder.kindergarten.service.impl;

import com.longder.kindergarten.entity.po.ClassDiet;
import com.longder.kindergarten.repository.ClassDietRepository;
import com.longder.kindergarten.service.ClassDietManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 餐饮管理
 */
@Service
public class ClassDietManageServiceImpl implements ClassDietManageService {

    @Resource
    private ClassDietRepository classDietRepository;

    /**
     * 添加每日饮食
     */
    @Override
    @Transactional
    public void addClassDiet(ClassDiet classDiet) {
        classDietRepository.save(classDiet);
    }

    /**
     * 查询某个某个班级下的餐饮情况
     */
    @Override
    public List<ClassDiet> listByClassId(Long classId) {
        return classDietRepository.listByClassId(classId);
    }
}
