package com.blog_management.repository;

import com.blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from Blog where title like %:keyword% limit :offset,:limit", nativeQuery = true)
    List<Blog> findByTitleContaining(@Param("keyword") String keyword,
                                     @Param("offset") int offset,
                                     @Param("limit") int limit);

    Page<Blog> findByTitleContaining(String searchTitle, Pageable pageable);

    @Query(value = "select b.* from `blog` b inner join `category` c " +
            "on b.category_id = c.id " +
            "where b.title like %:title% and c.name like %:category%", nativeQuery = true)
    Page<Blog> findByTitleAndCategory(@Param("title") String title, @Param("category") String category, Pageable pageable);

    @Query(value = "select * from Blog where category_id =:category_id", nativeQuery = true)
    List<Blog> findByCategory(@Param("category_id") int id);
}
