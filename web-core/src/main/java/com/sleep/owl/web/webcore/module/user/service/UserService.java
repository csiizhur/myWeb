package com.sleep.owl.web.webcore.module.user.service;

import com.sleep.owl.web.webcore.base.BaseService;
import com.sleep.owl.web.webcore.module.user.model.User;

import java.util.List;


public interface UserService extends BaseService<User, String> {
    List<User> findByName(String name);
}
