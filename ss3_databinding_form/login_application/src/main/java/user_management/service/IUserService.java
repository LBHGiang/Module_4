package user_management.service;

import user_management.model.Login;
import user_management.model.User;

public interface IUserService {

    User checkLogin(Login login);
}
