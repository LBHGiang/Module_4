package com.blog_management.service.blog_service;

import com.blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void remove(Blog blog);

    Page<Blog> findByTitleAndCategory(String title, String category, Pageable pageable);

    Page<Blog> findByTitle(String searchTitle, Pageable pageable);

    List<Blog> findByTitle(String searchTitle, int offset, int limit);

    List<Blog> findByCategory(int id);
}
