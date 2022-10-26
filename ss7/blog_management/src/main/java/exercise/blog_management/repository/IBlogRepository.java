package exercise.blog_management.repository;

import exercise.blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
//    @Query(value = "select * from Blog where name =:keyword", nativeQuery = true)
//    List<Blog> searchByName(@Param("keyword") String keyword);

    Page<Blog> findByTitleContaining(String searchTitle, Pageable pageable);
}
