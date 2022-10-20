package exercise.blog_management.service;

import exercise.blog_management.model.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void remove(Blog blog);

    List<Blog> findByTitle(String searchTitle);
}
