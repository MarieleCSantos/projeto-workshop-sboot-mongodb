package com.marielesantos.workshopmongo.services;

import com.marielesantos.workshopmongo.domain.Post;
import com.marielesantos.workshopmongo.repository.PostRepository;
import com.marielesantos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }


}
