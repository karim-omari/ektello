package com.ektello.demo.repositiories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ektello.demo.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
