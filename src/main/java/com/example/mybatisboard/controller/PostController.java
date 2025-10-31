package com.example.mybatisboard.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.mybatisboard.mapper.PostMapper;
import com.example.mybatisboard.model.Post;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/posts")
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
    public String showForm(Model model) {
        model.addAttribute("post", new Post());
        return "form"; // ← templates/form.html を表示
    }

    // 新規投稿フォーム表示
    @GetMapping("/add")
    public String showAddForm(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            // 未ログインならログイン画面へ
            return "redirect:/login";
        }
        model.addAttribute("post", new Post());
        return "post_form"; // templates/post_form.html
    }

    // 投稿処理
    @PostMapping("/add")
    public String add(Post post, HttpSession session) {
        String username = (String) session.getAttribute("user");
        if (username == null) {
            return "redirect:/login";
        }

        post.setUsername(username);
        if (post.getAuthor() == null || post.getAuthor().isEmpty()) {
            post.setAuthor(username);
        }

        postMapper.insert(post);
        return "redirect:/posts/";
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
