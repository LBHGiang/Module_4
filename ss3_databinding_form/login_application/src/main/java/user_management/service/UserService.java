package user_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_management.model.Login;
import user_management.model.User;
import user_management.repository.IUserRepository;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
