package com.company.surveycreator.model;

import com.company.surveycreator.model.base.BaseModel;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends BaseModel {
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
}
