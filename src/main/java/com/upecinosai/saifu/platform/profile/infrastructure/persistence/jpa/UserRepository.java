package com.upecinosai.saifu.platform.profile.infrastructure.persistence.jpa;

import com.upecinosai.saifu.platform.profile.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
