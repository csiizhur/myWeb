package com.sleep.owl.web.webcore.module.user.service.impl;

import com.sleep.owl.web.webcore.base.impl.BaseServiceImpl;
import com.sleep.owl.web.webcore.module.user.model.User;
import com.sleep.owl.web.webcore.module.user.repository.UserRepository;
import com.sleep.owl.web.webcore.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserRepository getDAO() {
        return userRepository;
    }

    @Override
    public List<User> findByName(String name) {
        return getDAO().findByName(name);
    }
}
