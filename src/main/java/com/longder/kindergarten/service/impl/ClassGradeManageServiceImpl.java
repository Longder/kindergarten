package com.longder.kindergarten.service.impl;

import com.longder.kindergarten.entity.po.ClassGrade;
import com.longder.kindergarten.entity.po.SysUser;
import com.longder.kindergarten.repository.ClassGradeRepository;
import com.longder.kindergarten.repository.SysUserRepository;
import com.longder.kindergarten.service.ClassGradeManageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassGradeManageServiceImpl implements ClassGradeManageService {

    @Resource
    private ClassGradeRepository classGradeRepository;

    @Resource
    private SysUserRepository sysUserRepository;

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
        SysUser sysUser = sysUserRepository.findById(classGrade.getTeacherId()).orElseThrow();
        classGrade.setTeacher(sysUser);
       classGradeRepository.save(classGrade);
    }

    /**
     * 查询某教师管理的所有班级
     *
     * @param teacherId
     */
    @Override
    public List<ClassGrade> listByTeacher(Long teacherId) {
        return classGradeRepository.listByTeacherId(teacherId);
    }

}
