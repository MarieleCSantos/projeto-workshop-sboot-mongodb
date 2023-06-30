package com.marielesantos.workshopmongo.services;

import com.marielesantos.workshopmongo.domain.Post;
import com.marielesantos.workshopmongo.repository.PostRepository;
import com.marielesantos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
    }

    public List<Post> findByTitle(String text) {
//        return repo.findByTitleContainingIgnoreCase(text);
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repo.fullSearch(text, minDate, maxDate);
    }
}
