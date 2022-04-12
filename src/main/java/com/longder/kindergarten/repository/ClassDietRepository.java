package com.longder.kindergarten.repository;

import com.longder.kindergarten.entity.po.ClassDiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 餐饮表操作
 */
public interface ClassDietRepository extends JpaRepository<ClassDiet,Long> {
    /**
     * 根据班级id查询班级下所有餐饮情况
     */
    @Query("select d from ClassDiet d where d.classGrade.id = :classId")
    List<ClassDiet> listByClassId(@Param("classId")Long classId);
}
