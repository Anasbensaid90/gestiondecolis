package com.anasdev.gestiondesutilisateursservice.dto;

import com.anasdev.gestiondesutilisateursservice.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {

    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String name;
    private String city;
    private String role;
    private String email;
    private String password;
    private Users Users;
    private List<Users> UsersList;

    // Default no-argument constructor
    public ReqRes() {
        // Initialisation par défaut si nécessaire
    }

    // Full constructor
    public ReqRes(int statusCode, String error, String message, String token, String refreshToken, String expirationTime,
                  String name, String city, String role, String email, String password, Users ourUsers, List<Users> ourUsersList) {
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.token = token;
        this.refreshToken = refreshToken;
        this.expirationTime = expirationTime;
        this.name = name;
        this.city = city;
        this.role = role;
        this.email = email;
        this.password = password;
        this.Users = ourUsers;
        this.UsersList = ourUsersList;
    }

    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users getUsers() {
        return Users;
    }

    public void setUsers(Users ourUsers) {
        this.Users = ourUsers;
    }

    public List<Users> getUsersList() {
        return UsersList;
    }

    public void setUsersList(List<Users> UsersList) {
        this.UsersList = UsersList;
    }

    // Builder pattern
    public static class Builder {
        private int statusCode;
        private String error;
        private String message;
        private String token;
        private String refreshToken;
        private String expirationTime;
        private String name;
        private String city;
        private String role;
        private String email;
        private String password;
        private Users Users;
        private List<Users> UsersList;

        public Builder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder refreshToken(String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public Builder expirationTime(String expirationTime) {
            this.expirationTime = expirationTime;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder users(Users Users) {
            this.Users = Users;
            return this;
        }

        public Builder usersList(List<Users> UsersList) {
            this.UsersList = UsersList;
            return this;
        }

        public ReqRes build() {
            return new ReqRes(statusCode, error, message, token, refreshToken, expirationTime, name, city, role, email, password, Users, UsersList);
        }
    }
}
