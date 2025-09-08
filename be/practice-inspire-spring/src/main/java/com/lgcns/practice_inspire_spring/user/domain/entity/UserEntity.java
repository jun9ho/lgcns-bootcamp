package com.lgcns.practice_inspire_spring.user.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.lgcns.practice_inspire_spring.blog.domain.entity.BlogEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {
    @Id
    private String email;
    @Column(nullable = false, length=50)
    private String passwd;
    @Column(nullable = false, length=50)
    private String name;

    @OneToMany(mappedBy="author",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<BlogEntity> blogs = new ArrayList<>();
    
}
