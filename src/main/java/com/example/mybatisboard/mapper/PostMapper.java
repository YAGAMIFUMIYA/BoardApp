package com.example.mybatisboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.mybatisboard.model.Post;
import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll();
    Post findById(int id);
    void insert(Post post);
    void update(Post post);
    void delete(Long id);
}
