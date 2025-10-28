package com.mzerek.springbootsolutions.service;

import com.mzerek.springbootsolutions.model.Role;
import com.mzerek.springbootsolutions.model.User;
import com.mzerek.springbootsolutions.model.UserPrincipal;
import com.mzerek.springbootsolutions.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Error 404");
        } else {
            Set<Role> roles = user.getRoles();
            return new UserPrincipal(user, roles);
        }
    }
}
