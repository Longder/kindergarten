package com.longder.kindergarten.entity.po;

import com.longder.kindergarten.entity.enumeration.DietType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 班级饮食记录
 */
@Entity
@Table(name = "CLASS_DIET")
@Getter
@Setter
public class ClassDiet extends BaseIdEntity{

    /**
     * 日期
     */
    @Column(name = "date_")
    private LocalDate date;

    /**
     * 餐饮类型
     */
    @Column(name = "diet_type_")
    @Enumerated(EnumType.STRING)
    private DietType dietType;

    /**
     * 餐饮内容
     */
    @Column(name = "content_")
    private String content;

    /**
     * 关联班级
     */
    @ManyToOne
    @JoinColumn(name = "class_grade_id_",referencedColumnName = "id_")
    private ClassGrade classGrade;
}
