package com.revature.foundation.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import com.revature.foundation.dtos.requests.LoginRequest;
import com.revature.foundation.dtos.requests.NewUserRequest;
import com.revature.foundation.dtos.requests.UpdatedUserRequest;
import com.revature.foundation.dtos.responses.AppUserResponse;
import com.revature.foundation.dtos.responses.ResourceCreationResponse;
import com.revature.foundation.models.UserRole;
import com.revature.foundation.models.User;

import com.revature.foundation.repository.UsersRepository;
import com.revature.foundation.util.Security;
import com.revature.foundation.util.exceptions.AuthenticationException;
import com.revature.foundation.util.exceptions.InvalidRequestException;
import com.revature.foundation.util.exceptions.ResourceConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


@Service
@ComponentScan("com.revature.foundation.util.Security")
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    // Constructor injection
    //If you only have one constructor then you dont really need this autowired tag ebcause its implied
    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }



    public List<User> getAll() {
        List<User> users = (List<User>) usersRepository.findAll();
        List<AppUserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            userResponses.add(new AppUserResponse(user));
        }

        return users;
    }

//TODO either uncomment or determine that it is in fact redundant

//    public User updatedUser(UpdatedUserRequest updateRequest) {
//        User updatedUser = updateRequest.extractUser();
//
//        usersRepository.save(updatedUser);
//        return updatedUser;
//    }

    public ResourceCreationResponse register(NewUserRequest newUserRequest) throws NoSuchAlgorithmException, InvalidKeySpecException {

        User newUser = newUserRequest.extractUser();

        if (!isUserValid(newUser)) {
            throw new InvalidRequestException("Bad registration details given.");
        }

        boolean usernameAvailable = isUsernameAvailable(newUser.getUsername());
        boolean emailAvailable = isEmailAvailable(newUser.getEmail());

        if (!usernameAvailable || !emailAvailable) {
            String msg = "The values provided for the following fields are already taken by other users: ";
            if (!usernameAvailable) msg += "username ";
            if (!emailAvailable) msg += "email";
            throw new ResourceConflictException(msg);
        }


        newUser.setUserId(UUID.randomUUID().toString());
        newUser.setRole(new UserRole("3", "Employee")); // All newly registered users start as BASIC_USER
        newUser.setIsActive(false);
//
        String encryptedPassword = Security.generateStrongPasswordHash(newUser.getPassword());
        newUser.setPassword(encryptedPassword);
        usersRepository.save(newUser);
// TODO        return new ResourceCreationResponse(newCustomer.getId());
        return new ResourceCreationResponse(newUser.getUserId());
//        return newUser;
    }




    private boolean isUserValid(User appUser) {

        // First name and last name are not just empty strings or filled with whitespace
        if (appUser.getGivenName().trim().equals("") || appUser.getSurname().trim().equals("")) {
            return false;
        }

        // Usernames must be a minimum of 8 and a max of 25 characters in length, and only contain alphanumeric characters.
        if (!isUsernameValid(appUser.getUsername())) {
            return false;
        }

        // Passwords require a minimum eight characters, at least one uppercase letter, one lowercase
        // letter, one number and one special character
        if (!isPasswordValid(appUser.getPassword())) {
            return false;
        }

        // Basic email validation
        return isEmailValid(appUser.getEmail());

    }

    public boolean isEmailValid(String email) {
        if (email == null) return false;
        return email.matches("^[^@\\s]+@[^@\\s.]+\\.[^@.\\s]+$");
    }

    public boolean isUsernameValid(String username) {
        if (username == null) return false;
        return username.matches("^[a-zA-Z0-9]{8,25}");
//        return false;
    }

    public boolean isPasswordValid(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
//        return false;
    }

    public boolean isUsernameAvailable(String username) {
        if (username == null || !isUsernameValid(username)) return false;
        return usersRepository.findByusername(username) == null;
    }

    public boolean isEmailAvailable(String email) {
        if (email == null || !isEmailValid(email)) return false;
        return usersRepository.findByemail(email) == null;
    }

    public User login(LoginRequest loginRequest) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (!isUsernameValid(username) || !isPasswordValid(password)) {
            throw new InvalidRequestException("Invalid credentials provided!");
        }


        User authUser = usersRepository.getUserByUsernameandPassword(username, password);
        //String encryptedPassword = Security.generateStrongPasswordHash(password);
        authUser.setPassword(password);
        System.out.println(authUser);

        if (authUser == null) {

            throw new AuthenticationException();

        }
// TODO for Art: using the autowired Security component, validate the provided password to the stored one using Security#validatePassword
       // if (!Security.validatePassword(authUser.getPassword(), password))
        // TODO for Art: if the passwords do not match, throw an AuthenticationException

        return authUser;

    }

    public User login(NewUserRequest newUserRequest) {
        String username = newUserRequest.getUsername();
        String password = newUserRequest.getPassword();

        if (!isUsernameValid(username) || !isPasswordValid(password)) {
            throw new InvalidRequestException("Invalid credentials provided!");
        }

        // TODO encrypt provided password (assumes password encryption is in place) to see if it matches what is in the DB
        User authUser = usersRepository.getUserByUsernameandPassword(username, password);
        System.out.println(authUser);

        if (authUser == null) {

            throw new AuthenticationException();
        }

        return authUser;

    }
}
