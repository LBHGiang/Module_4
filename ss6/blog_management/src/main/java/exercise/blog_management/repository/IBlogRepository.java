package exercise.blog_management.repository;

import exercise.blog_management.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
//    @Query(value = "select * from Blog where name =:keyword", nativeQuery = true)
//    List<Blog> searchByName(@Param("keyword") String keyword);

    List<Blog> findByTitleContaining(String searchTitle);
}
