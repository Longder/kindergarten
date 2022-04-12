package com.longder.kindergarten.repository;


import com.longder.kindergarten.entity.po.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 每日所学数据表操作
 */
public interface CourseRepository extends JpaRepository<Course,Long> {

    /**
     * 查询班级下所有的课程内容
     */
    @Query("select c from Course c where c.classGrade.id = :classId")
    List<Course> listByClassId(@Param("classId")Long classId);
}
