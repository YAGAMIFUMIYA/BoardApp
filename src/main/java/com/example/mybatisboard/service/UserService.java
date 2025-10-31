package com.example.mybatisboard.service;

import com.example.mybatisboard.model.User;
import com.example.mybatisboard.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ユーザー登録
    public void register(User user) {
        // パスワードをハッシュ化して保存
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insertUser(user); // ← 修正ポイント
    }

    // ユーザー名で検索
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    // 認証処理
    public boolean authenticate(String username, String rawPassword) {
        User user = findByUsername(username);
        return user != null && passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
