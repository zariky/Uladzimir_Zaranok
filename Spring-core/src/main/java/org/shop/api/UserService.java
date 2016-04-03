package org.shop.api;

import java.util.List;

import org.shop.data.User;

public interface UserService {

    Long registerUser(User user);
    
    User getUserById(Long id);
    
    void updateUserProfile(User user);
    
    List<User> getUsers();
}
