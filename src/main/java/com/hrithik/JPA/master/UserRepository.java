package com.hrithik.JPA.master;

import com.hrithik.MasterObjects.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDO,Long> {
}
