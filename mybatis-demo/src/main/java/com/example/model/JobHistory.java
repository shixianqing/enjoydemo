package com.example.model;

import lombok.Data;
import lombok.ToString;

/**
 * @author shixianqing
 */
@Data
@ToString
public class JobHistory {
    private Integer id;

    private Integer userId;

    private String compName;

    private Integer years;

    private String title;
}