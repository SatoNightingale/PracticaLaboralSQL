package com.satoshihans.practicalaboralsql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.satoshihans.practicalaboralsql.models.mappers.AdvanceMapper;


@Service
public abstract class AbstractService<T> {

    protected JpaRepository<T, Long> getRepository(){
        return null;
    }

    @Autowired
    protected AdvanceMapper mapper;

    public List<?> listar(){
        // return getRepository().findAll().stream().map(
        //     (T e) -> mapper.toDTO(e)).toList();
        return null;
    }

    public T add_entity(){
        return null;
    }

    public T getById(Long id){
        return getRepository().findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public boolean existsById(Long id){
        return getRepository().existsById(id);
    }
}
