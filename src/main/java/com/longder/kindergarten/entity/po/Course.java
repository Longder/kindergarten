package com.longder.kindergarten.entity.po;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 每日所学课程内容表
 */
@Entity
@Table(name = "COURSE")
@Getter
@Setter
public class Course extends BaseIdEntity{
    /**
     * 关联班级
     */
    @ManyToOne
    @JoinColumn(name = "class_grade_id_",referencedColumnName = "id_")
    private ClassGrade classGrade;

    /**
     * 日期
     */
    @Column(name = "date_")
    private LocalDate date;

    /**
     * 课程内容
     */
    @Column(name = "content_")
    private String content;
}
