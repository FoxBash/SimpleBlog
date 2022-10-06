package com.paul.SimpleBlog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor
public class Authority  implements Serializable {
    public enum Role{
        ROLE_USER,ROLE_ADMIN
    }

}
