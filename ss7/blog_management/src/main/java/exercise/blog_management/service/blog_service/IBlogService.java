package exercise.blog_management.service.blog_service;

import exercise.blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

//    List<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void remove(Blog blog);

    Page<Blog> findByTitle(String searchTitle, Pageable pageable);
}
