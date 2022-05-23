package com.shawn.tutorial.repository;

import com.shawn.tutorial.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>    {
    @EntityGraph(attributePaths = "authorities")    //@EntityGraph는 쿼리 수행 시 Lazy 조회가 아닌 Eager 조회로 authorities 정보를 같이 가져온다.
    Optional<User> findOneWithAuthoritiesByUsername(String username);   //username을 기준으로 권한 정보와 함께 user 정보를 가져오는 메서드.
}
