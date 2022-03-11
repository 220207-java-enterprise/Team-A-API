//package com.revature.foundation.util;
//
//import com.revature.foundation.models.UserRole;
//import com.revature.foundation.models.Users;
//import com.revature.foundation.repository.UsersRepository;
//import org.apache.catalina.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import javax.transaction.Transactional;
//
//import static java.util.UUID.randomUUID;
//
////@Component
//public class UserInserter implements CommandLineRunner {
//
//    private final UsersRepository usersRepository;
//
//    @Autowired
//    public UserInserter(UsersRepository usersRepository) {
//        this.usersRepository=usersRepository;
//    }
//
//    @Override
//    @Transactional
//    public void run(String... args) {
//        // Write persistence logic for user data
//        Users users1=new Users();
//        users1.setUserId(randomUUID().toString());
//        users1.setUsername("username");
//        users1.setEmail("email@revature.net");
//        users1.setPassword("LetThisBeALessonToYou!1");
//        users1.setGivenName("givenName");
//        users1.setSurname("surname");
//        users1.setIsActive(false);
//        users1.setRole(new UserRole("3", "EMPLOYEE"));
//        usersRepository.save(users1);
//
//
//    }
//}
