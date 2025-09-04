package com.lgcns.inspire_restjpa.user.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.lgcns.inspire_restjpa.blog.domain.entity.BlogEntity;

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

//table을 의미
@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {
    
    //primary key
    @Id
    private String email; 
    @Column (nullable=false, length = 50, unique = true)
    private String passwd;
    @Column (nullable=false, length = 50)
    private String name;

    //cascade에 의해서 유저가 만약 탈티했으면 블로그 다 삭제?
    //@OneToMany(mappedBy= "author" ,orphanRemoval = false)
    @OneToMany(mappedBy= "author",cascade = CascadeType.ALL ,orphanRemoval = false)
    private List<BlogEntity> blogs  = new ArrayList<>();

    //@OneToMany(mappedBy= "author" ,orphanRemoval = false)
    //private List<BlogEntity> comments  = new ArrayList<>();


}
