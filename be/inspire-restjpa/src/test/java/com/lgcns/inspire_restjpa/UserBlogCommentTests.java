package com.lgcns.inspire_restjpa;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.lgcns.inspire_restjpa.blog.domain.dto.BlogRequestDTO;
import com.lgcns.inspire_restjpa.blog.domain.entity.BlogEntity;
import com.lgcns.inspire_restjpa.blog.repositroy.BlogRepository;
import com.lgcns.inspire_restjpa.comment.domain.dto.CommentRequestDTO;
import com.lgcns.inspire_restjpa.comment.domain.entity.CommentEntity;
import com.lgcns.inspire_restjpa.comment.repository.CommentRepository;
import com.lgcns.inspire_restjpa.user.domain.dto.UserRequestDTO;
import com.lgcns.inspire_restjpa.user.domain.dto.UserResponseDTO;
import com.lgcns.inspire_restjpa.user.domain.entity.UserEntity;
import com.lgcns.inspire_restjpa.user.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class UserBlogCommentTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CommentRepository commentRepository;

    /*
     * 로그인 한 사용자가 있고
     * 로그인 한 사용자가 Blog 작성(author)
     * Comment 작성 시 (blog)
     * Blog 조회 시 -> user and comment 연관관계를 검증
     * Blog 삭제 시 ->
     */

    @Test
    @Transactional
    @Commit
    public void user_blog_comment() {

        UserRequestDTO request = UserRequestDTO.builder()
                .email("jungho88@naver.com")
                .passwd("123488")
                .name("김정호")
                .build();

        userRepository.save(request.toEntity());
        UserEntity findUser = userRepository.findByEmailAndPasswd(request.getEmail(), request.getPasswd());

        UserResponseDTO response = UserResponseDTO.fromEntity(findUser);
        System.out.println(">>> 회원가입 후 로그인 성공");
        System.out.println(">>> " + response);

        BlogRequestDTO blogRequest = BlogRequestDTO.builder().title("ddd").content("안녕")
                .authorEmail("jungho88@naver.com").build();

        Optional<UserEntity> user = userRepository.findById(blogRequest.getAuthorEmail());
        BlogEntity blog = blogRepository.save(BlogEntity.builder()
                .title(blogRequest.getTitle())
                .content(blogRequest.getContent())
                .author(user.get())
                .build());

        CommentRequestDTO commentRequest = CommentRequestDTO.builder()
                .blogId(1)
                .comment("비밀")
                .build();
        BlogEntity findBlog = blogRepository.findById(commentRequest.getBlogId())
                .orElseThrow(() -> new RuntimeException("블로그 존재 x"));
        CommentEntity comment = commentRepository.save(CommentEntity.builder().comment("파이팅").blog(findBlog).build());

        // Optional<CommentEntity> comment =
        // commentRepository.save(CommentEntity.builder().comment("hmm").blog(blog).build());
    }
}
