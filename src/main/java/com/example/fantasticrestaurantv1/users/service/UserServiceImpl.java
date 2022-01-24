package com.example.fantasticrestaurantv1.users.service;

import com.example.fantasticrestaurantv1.users.domain.Role;
import com.example.fantasticrestaurantv1.users.domain.User;
import com.example.fantasticrestaurantv1.users.domain.UserType;
import com.example.fantasticrestaurantv1.users.repository.RoleRepository;
import com.example.fantasticrestaurantv1.users.repository.UserRepository;
import com.example.fantasticrestaurantv1.users.validation.UserValidationResult;
import com.example.fantasticrestaurantv1.users.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserValidator userValidator;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new IllegalStateException("User not found");
        } else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(
                    role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), user.getPassword(), authorities);
        }
    }

    @Override
    public void registerUser(User user) {
        UserValidationResult result = userValidator.apply(user);
        if (result == UserValidationResult.SUCCESS) {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
        } else {
            throw new IllegalStateException("There was an error creating the user: " + result);
        }
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findUserByUsername(username);
        Collection<Role> roles = user.getRoles();
        Role roleToAdd = roleRepository.findByName(roleName);
        roles.add(roleToAdd);
        user.setRoles(roles);
    }

    @Override
    public Optional<Role> getUserRole(String username) {
        User user = userRepository.findUserByUsername(username);
        return user.getRoles().stream().findFirst();
    }

    @Override
    public Collection<Role> getUserRoles(String username) {
        User user = userRepository.findUserByUsername(username);
        return user.getRoles();
    }

    @Override
    public UserType getUserType(String username) {
        User user = userRepository.findUserByUsername(username);
        return user.getUserType();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
