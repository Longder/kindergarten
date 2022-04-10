package com.longder.kindergarten.service.impl;

import com.longder.kindergarten.entity.po.ClassGrade;
import com.longder.kindergarten.repository.ClassGradeRepository;
import com.longder.kindergarten.service.ClassGradeManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassGradeManageServiceImpl implements ClassGradeManageService {

    @Resource
    private ClassGradeRepository classGradeRepository;

    /**
     * 查询所有班级
     *
     * @return
     */
    @Override
    public List<ClassGrade> listClassGrade() {
        return classGradeRepository.findAll();
    }

    /**
     * 新增班级
     *
     */
    @Override
    @Transactional
    public void addClassGrade(ClassGrade classGrade) {
       classGradeRepository.save(classGrade);
    }

}
