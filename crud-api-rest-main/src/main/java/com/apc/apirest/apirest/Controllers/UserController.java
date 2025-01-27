package com.apc.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apc.apirest.apirest.Entities.User;
import com.apc.apirest.apirest.Services.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> listarTodos(){
        return userService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(userService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<User> crearUsuario(@RequestBody User usuario){
        return new ResponseEntity<>(userService.crearUsuario(usuario),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> actualizarUsuario(@PathVariable Long id, @RequestBody User detallesUsuario) {
        return ResponseEntity.ok(userService.actualizarUsuario(id, detallesUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        userService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
