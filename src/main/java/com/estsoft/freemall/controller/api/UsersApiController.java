package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.UsersRequest;
import com.estsoft.freemall.entity.Users;
import com.estsoft.freemall.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersApiController {
    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<Users> register(@RequestBody UsersRequest request) {
        return ResponseEntity.ok(usersService.register(request));
    }

    @GetMapping
    public ResponseEntity<Users> getById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(usersService.getById(id));
    }
}
