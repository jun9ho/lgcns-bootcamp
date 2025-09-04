package com.lgcns.inspire_restjpa.blog.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lgcns.inspire_restjpa.blog.domain.entity.BlogEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Integer>{
    
}
