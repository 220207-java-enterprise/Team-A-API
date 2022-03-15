package com.revature.foundation.repository;

import com.revature.foundation.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, String> {

//    @Query("from Users u where u.userId = ?1") // JPQL/HQL
//    @Query(value = "select * from ers_users where ers_users.user_id = ?1", nativeQuery = true)
//    User getUserById(String user_id);

    @Query(value = "select * from technologyp.ers_users u where u.username = ?1 AND u.password = ?2", nativeQuery = true)
    User getUserByUsernameandPassword(String username, String password);

}
