package com.longder.kindergarten.repository;

import com.longder.kindergarten.entity.po.ClassGrade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 班级表操作
 */
public interface ClassGradeRepository extends JpaRepository<ClassGrade,Long> {
}
