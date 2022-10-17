package user_management.repository;

import user_management.model.Login;
import user_management.model.User;

public interface IUserRepository {

    User checkLogin(Login login);

}
