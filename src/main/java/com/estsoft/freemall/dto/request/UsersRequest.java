package com.estsoft.freemall.dto.request;

import com.estsoft.freemall.entity.Users;
import com.estsoft.freemall.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsersRequest {
    private String loginId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String address;

    public Users toEntity() {
        return Users.builder()
                .loginId(loginId)
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .dateOfBirth(dateOfBirth)
                .gender(gender)
                .address(address).build();
    }

    public Users updateEntity(Users user) {
        if(!address.isEmpty()) {
            user.setAddress(address);
        }
        return user;
    }
}
