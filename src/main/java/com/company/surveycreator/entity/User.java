package com.company.surveycreator.entity;

import com.company.surveycreator.entity.base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseModel{

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

}
