package com.apc.apirest.apirest.Services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.apc.apirest.apirest.Repositories.UserRepository;
import com.apc.apirest.apirest.Entities.User;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> listarTodos(){
        return userRepository.findAll();
    }

    public User obtenerPorId(Long id){
        return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public User crearUsuario(User usuario){
        return userRepository.save(usuario);
    }

    public User actualizarUsuario(Long id, User detallesUsuario){
        User user = obtenerPorId(id);
        user.setUsername(detallesUsuario.getUsername());
        user.setEmail(detallesUsuario.getEmail());
        return userRepository.save(user);
    }

    public void eliminarUsuario(Long id){
        userRepository.deleteById(id);
    }

}
