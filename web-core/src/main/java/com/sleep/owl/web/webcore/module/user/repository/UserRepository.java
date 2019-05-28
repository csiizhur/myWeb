package com.sleep.owl.web.webcore.module.user.repository;

import com.sleep.owl.web.webcore.base.BaseRepository;
import com.sleep.owl.web.webcore.module.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User, String> {
    List<User> findByName(String name);
}
