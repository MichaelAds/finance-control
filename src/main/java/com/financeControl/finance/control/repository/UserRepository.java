package com.financeControl.finance.control.repository;

import com.financeControl.finance.control.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
