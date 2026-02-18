package com.bebidas.controller;

import com.bebidas.model.Bebida;
import com.bebidas.repository.BebidaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bebidas")
@CrossOrigin(origins = "*")
public class BebidaController {

    private final BebidaRepository repository;

    public BebidaController(BebidaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Bebida> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Bebida salvar(@RequestBody Bebida bebida) {
        return repository.save(bebida);
    }
}
