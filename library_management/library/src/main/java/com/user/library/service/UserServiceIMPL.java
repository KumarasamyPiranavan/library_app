package com.user.library.service;

import com.user.library.DTO.UserDTO;
import com.user.library.DTO.UserSaveDTO;
import com.user.library.entity.User;
import com.user.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(UserSaveDTO userSaveDTO) {

        User user = new User(

                userSaveDTO.getName()
        );
        userRepository.save(user);
        return user.getName();
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> getUsers = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for(User a:getUsers)
        {
            UserDTO userDTO = new UserDTO(
                    a.getId(),
                    a.getName()
            );
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }


}
