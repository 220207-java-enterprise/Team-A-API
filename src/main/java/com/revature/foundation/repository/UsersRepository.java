package com.revature.foundation.repository;

import com.revature.foundation.models.Reimbursements;
import com.revature.foundation.models.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {

    @Query("from Users u where u.userId = ?1") // JPQL/HQL
//    @Query(value = "select * from ers_users where ers_users.user_id = ?1", nativeQuery = true)
    Users getUserById(String user_id);


}
