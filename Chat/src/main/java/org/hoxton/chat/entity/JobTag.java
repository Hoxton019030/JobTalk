package org.hoxton.chat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "jobTag")
@Entity(name = "jobTag")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobTag implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    /**
     * 目錄Id
     */
    @Column(name = "category_Id")
    private Integer categoryId;
    /**
     * 職業名稱
     */
    @Column(name = "job_Name")
    private String jobName;
    /**
     * 職業描述
     */
    @Column(name = "job_Description")
    private String jobDescription;
    /**
     * 創建時間
     */
    @Column(name = "job_Image")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
