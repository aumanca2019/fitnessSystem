package com.fitness.model.service;

import com.fitness.model.model.Role;
import com.fitness.model.model.User;
import com.fitness.model.repository.RoleRepository;
import com.fitness.model.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private static UsernameNotFoundException get() {
        return new UsernameNotFoundException("User not Found");
    }

    public User findByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(UserService::get);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }

    public void save(User user) throws NotFoundException {
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setRole(roleRepository.findById(1l).orElseThrow(()->{
            return new NotFoundException("Role not found");
        }));
        userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void changeRole(Long id, Long roleId) throws NotFoundException {
        User user = userRepository.findById(id).orElseThrow(UserService::get);
        Role role = roleRepository.findById(roleId).orElseThrow(()->{
            return new NotFoundException("Role not found");
        });
        user.setRole(role);
        userRepository.save(user);
    }

    public Iterable<User> findAllTrainers() {
        Iterable<User> users = findAll();
        return StreamSupport.stream(users.spliterator(),false).filter(
                 user -> user.getRole().getId() == 2).collect(Collectors.toList());
    }
}
