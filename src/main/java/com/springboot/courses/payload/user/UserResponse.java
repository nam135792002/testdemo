package com.springboot.courses.payload.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Integer id;

    @JsonProperty("full_name")
    private String fullName;

    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String photo;

    @JsonProperty("created_time")
    private Date createdTime;

    private boolean enabled;

    private String roleName;
}
