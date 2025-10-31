package com.example.mybatisboard.repository;

import com.example.mybatisboard.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    // ユーザー名で検索（ログイン時に使用）
    @Select("SELECT id, username, password FROM users WHERE username = #{username}")
    User findByUsername(String username);

    // 新規登録
    @Insert("INSERT INTO users (username, password) VALUES (#{username}, #{password})")
    void insertUser(User user);
}
