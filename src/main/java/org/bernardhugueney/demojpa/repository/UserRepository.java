package org.bernardhugueney.demojpa.repository;

import org.bernardhugueney.demojpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
