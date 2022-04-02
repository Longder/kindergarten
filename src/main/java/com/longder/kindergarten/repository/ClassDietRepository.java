package com.longder.kindergarten.repository;

import com.longder.kindergarten.entity.po.ClassDiet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 餐饮表操作
 */
public interface ClassDietRepository extends JpaRepository<ClassDiet,Long> {

}
