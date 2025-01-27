package com.apc.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apc.apirest.apirest.Entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
