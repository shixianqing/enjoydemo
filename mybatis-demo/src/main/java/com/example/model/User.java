package com.example.model;

import lombok.*;

import java.util.List;

/**
 * @author shixianqing
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;

    private String userName;

    private String realName;

    private Byte sex;

    private String mobile;

    private String email;

    private String note;

    private Integer positionId;

    private Position position;

    private List<JobHistory> jobHistories;

    private List<Role> roles;

//    public User(Integer id, String userName) {
//        this.id = id;
//        this.userName = userName;
//    }
}