package dio.web.api.controller;


import dio.web.api.model.Usuario;
import dio.web.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    private UserRepository repository;
    @GetMapping("users")
    public List<Usuario> getUsers(){
        return repository.findAll();
    }
    @PostMapping("/usuarios")
    public void post(@RequestBody Usuario usuario){
        repository.save(usuario);
    }
    @PutMapping("/usuarios")
    public void put(@RequestBody Usuario usuario){
        repository.update(usuario);
    }
    @GetMapping("/users/{username}")
    public Usuario getOne(String username){
        return  repository.findByUsername(username);
    }
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

}

