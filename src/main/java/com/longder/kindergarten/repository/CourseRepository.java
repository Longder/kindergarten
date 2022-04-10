package com.longder.kindergarten.repository;


import com.longder.kindergarten.entity.po.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 每日所学数据表操作
 */
public interface CourseRepository extends JpaRepository<Course,Long> {

}
