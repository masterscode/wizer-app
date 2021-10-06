package com.library.services.implementations;

import com.library.configurations.security.ERole;
import com.library.models.Role;
import com.library.models.User;
import com.library.payloads.requests.LoginRequest;
import com.library.payloads.requests.UserRegistrationRequest;
import com.library.payloads.response.LoginResponse;
import com.library.payloads.response.UserRegistrationResponse;
import com.library.repositories.RoleRepository;
import com.library.repositories.UserRepository;
import com.library.services.UserService;
import com.library.utils.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Lazy))
public class UserServiceImpl implements UserService {

    private final ModelMapper modelmapper;
    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final PasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return repository.findByEmail(s).orElseThrow(()-> new UsernameNotFoundException("The Requested User is not found"));
    }

    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
        User userToRegister = modelmapper.map(request, User.class);
        Role role = roleRepository.findByName(ERole.USER);
        log.info(role.toString());
        userToRegister.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        userToRegister.setRoles(List.of(role));

        User registeredUser = repository.save(userToRegister);
        var response = modelmapper.map(registeredUser, UserRegistrationResponse.class);
        List<String> roles = registeredUser.getRoles().stream().map(registered -> registered.getAuthority()).toList();

        response.setRoles(roles);

        return response;
    }

    @Override
    public LoginResponse loginUser(LoginRequest request) {

        Authentication authentication = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(), request.getPassword()
                        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails loggedInUser = loadUserByUsername(request.getEmail());

        final String jwtToken = jwtUtil.generateToken(loggedInUser);

        final List<String> roles = loggedInUser
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        var response = modelmapper.map(loggedInUser, LoginResponse.class);
        response.setToken(jwtToken);
        response.setRoles(roles);

        return response;
    }
}
