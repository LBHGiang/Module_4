package exercise.user_login.service;

import exercise.user_login.model.Song;
import exercise.user_login.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository userRepository;

    @Override
    public List<Song> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(Song song) {
        userRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
