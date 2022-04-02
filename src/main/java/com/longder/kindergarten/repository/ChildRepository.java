package com.longder.kindergarten.repository;

import com.longder.kindergarten.entity.po.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child,Long> {
}
