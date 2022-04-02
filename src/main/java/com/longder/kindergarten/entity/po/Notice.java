package com.longder.kindergarten.entity.po;

import com.longder.kindergarten.entity.enumeration.NoticeType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 公告内容表
 */
@Entity
@Table(name = "NOTICE")
@Getter
@Setter
public class Notice extends BaseIdEntity{

    /**
     * 标题
     */
    @Column(name = "title_")
    private String title;

    /**
     * 公告类型
     */
    @Column(name = "notice_type_")
    private NoticeType noticeType;

    /**
     * 内容
     */
    @Column(name = "content_")
    private String content;
}
