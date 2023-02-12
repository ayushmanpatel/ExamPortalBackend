package com.examportal.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class UserRole {

    @Id
    @GeneratedValue
    private Long userRoleId;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserRole userRole = (UserRole) o;
        return userRoleId != null && Objects.equals(userRoleId, userRole.userRoleId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
