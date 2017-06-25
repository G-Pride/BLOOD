package com.dfish.domain.repository;

import com.dfish.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/4/6 0006.
 */
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String name);
}
