package com.longder.kindergarten.repository;

import com.longder.kindergarten.entity.po.ClassGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 班级表操作
 */
public interface ClassGradeRepository extends JpaRepository<ClassGrade,Long> {
    /**
     * 根据教师查询教师管理的所有班级
     */
    @Query("select c from ClassGrade c where c.teacher.id = :teacherId")
    List<ClassGrade> listByTeacherId(@Param("teacherId")Long teacherId);
}
