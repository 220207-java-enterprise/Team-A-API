package com.revature.foundation.repository;

import com.revature.foundation.models.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, String> {


    @Query(value = "select * from ers_users u where u.username = ?1 AND u.password = ?2", nativeQuery = true)
    User getUserByUsernameandPassword(String username, String password);


    @Modifying
    User createNewUser(String user_id, String username, String email, String password, String givenName, String surname, String is_active, String role);

    @Query(value = "select * from ers_users eu where username = ?1", nativeQuery = true)
    User findByusername(String username);

    @Query(value = "select * from ers_users eu where email = ?1", nativeQuery = true)
    User findByemail(String email);

}
