package com.siteware.ecommerce.repositories;

import com.siteware.ecommerce.entinties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
