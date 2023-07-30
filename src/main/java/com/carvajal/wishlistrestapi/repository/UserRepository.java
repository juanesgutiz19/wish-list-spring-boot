package com.carvajal.wishlistrestapi.repository;

import com.carvajal.wishlistrestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, UUID> {
}
