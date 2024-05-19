package com.user.library.service;

import com.user.library.DTO.UserDTO;
import com.user.library.DTO.UserSaveDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUser();
}
