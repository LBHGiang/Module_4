package exercise.blog_management.service.blog_service;

import exercise.blog_management.model.Blog;
import exercise.blog_management.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

//    @Override
//    public List<Blog> findAll() {
//        return blogRepository.findAll();
//    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Page<Blog> findByTitle(String searchTitle, Pageable pageable) {
        return blogRepository.findByTitleContaining(searchTitle, pageable);
    }
}
