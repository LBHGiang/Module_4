package com.blog_management.rest_controller;


import com.blog_management.model.Blog;
import com.blog_management.service.blog_service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class RestBlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> list() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> details(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/search?searchName=keyword")
    public ResponseEntity<List<Blog>> searchList(@RequestParam(value = "keyword", defaultValue = "")
                                                             String keyword){
        List<Blog> blogList = blogService.findByTitle(keyword);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }



}
