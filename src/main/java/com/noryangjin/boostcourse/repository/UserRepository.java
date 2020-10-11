package com.noryangjin.boostcourse.repository;

import com.noryangjin.boostcourse.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByEmail(String email);
}