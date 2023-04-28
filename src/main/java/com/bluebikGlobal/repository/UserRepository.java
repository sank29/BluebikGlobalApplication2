package com.bluebikGlobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebikGlobal.entity.Account;
import com.bluebikGlobal.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	

}
