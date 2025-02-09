package com.estsoft.freemall.controller.api;

import com.estsoft.freemall.dto.request.UsersRequest;
import com.estsoft.freemall.entity.Users;
import com.estsoft.freemall.service.CartService;
import com.estsoft.freemall.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersApiController {
    private final UsersService usersService;
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<Users> register(@RequestBody UsersRequest request) {
        Users user = usersService.register(request);
        cartService.addCart(user.getId());

        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getById(@PathVariable Long userId) {
        return ResponseEntity.ok(usersService.getUserById(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Users> deleteById(@PathVariable Long userId) {
        return ResponseEntity.ok(usersService.softDelete(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Users> update(@PathVariable Long userId, @RequestBody UsersRequest request) {
        return ResponseEntity.ok(usersService.update(userId, request));
    }
}
