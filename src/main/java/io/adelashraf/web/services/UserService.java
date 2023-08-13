package io.adelashraf.web.services;

import io.adelashraf.web.dto.RegistrationDto;
import io.adelashraf.web.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
