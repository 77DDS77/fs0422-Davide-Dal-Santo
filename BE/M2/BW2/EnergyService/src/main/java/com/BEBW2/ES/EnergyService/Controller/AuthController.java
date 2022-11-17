package com.BEBW2.ES.EnergyService.Controller;

import com.BEBW2.ES.EnergyService.Security.JwtUtils;
import com.BEBW2.ES.EnergyService.Security.details.UserDetailsImpl;
import com.BEBW2.ES.EnergyService.Security.login.LoginRequest;
import com.BEBW2.ES.EnergyService.Security.login.LoginResponse;
import com.BEBW2.ES.EnergyService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(method = {RequestMethod.POST}, value="/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService us;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        authentication.getAuthorities();

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new LoginResponse(jwt, userDetails.getId(), userDetails.getUsername(),
                roles, userDetails.getExpirationTime()));
    }
}
