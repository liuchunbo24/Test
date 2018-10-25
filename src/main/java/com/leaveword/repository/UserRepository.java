package com.leaveword.repository;

import com.leaveword.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/7/24.
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    User findByUserName(String userName);
    User findOne(Integer userId);
}
