package com.marielesantos.workshopmongo.services;

import com.marielesantos.workshopmongo.domain.User;
import com.marielesantos.workshopmongo.repository.UserRepository;
import com.marielesantos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }
}
