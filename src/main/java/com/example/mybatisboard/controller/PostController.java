package com.example.mybatisboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.mybatisboard.mapper.PostMapper;
import com.example.mybatisboard.model.Post;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private final PostMapper postMapper;

    public PostController(PostMapper postMapper) {
        this.postMapper = postMapper;
    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postMapper.findAll());
        return "index";
    }
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("post",new Post());
    return  "form";
    }
    @PostMapping("/add")
    public String add(Post post){
        postMapper.insert(post);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Post post = postMapper.findById(id);
        model.addAttribute("post",post);
        return   "edit";
    }
    @PostMapping("/update")
    public String update(Post post){
        postMapper.update(post);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        postMapper.delete(id);
        return "redirect:/";
    }
}
