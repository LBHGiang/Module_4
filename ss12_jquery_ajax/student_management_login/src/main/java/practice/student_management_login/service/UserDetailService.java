package practice.student_management_login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practice.student_management_login.model.MyUserDetail;
import practice.student_management_login.model.User;
import practice.student_management_login.repository.IUserRepository;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User name: " + username + " not found");
        }
        return new MyUserDetail(user);
    }
}

