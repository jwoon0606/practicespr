package com.example.practicespr.service.impl;

import com.example.practicespr.domain.User;
import com.example.practicespr.repository.UserRepository;
import com.example.practicespr.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public Long create(Map<String, Object> params) {
        return null;
    }

    @Override
    public void update(Map<String, Object> params) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User detail(Long id) {
        return null;
    }

    @Override
    public List<User> list() {
        return null;
    }
}
