package exercise.user_login.service;

import exercise.user_login.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    void save(Song song);

    Song findById(Integer id);
}
