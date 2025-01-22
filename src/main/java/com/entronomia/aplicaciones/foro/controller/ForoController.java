package com.entronomia.aplicaciones.foro.controller;

import com.entronomia.aplicaciones.foro.dto.TopicoDatos;
import com.entronomia.aplicaciones.foro.dto.TopicoDatosAActualizar;
import com.entronomia.aplicaciones.foro.dto.TopicoDatosAMostrar;
import com.entronomia.aplicaciones.foro.model.Topico;
import com.entronomia.aplicaciones.foro.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class ForoController {

    @Autowired
    TopicoRepository topicoRepository;

    @GetMapping()
    public List<TopicoDatosAMostrar> ListarTopicos(){
        return topicoRepository.findAll().stream().map(TopicoDatosAMostrar::new).toList();
    }

    @PostMapping()
    public void registrarTopico(@RequestBody @Valid TopicoDatos topicoDatos) {
        topicoRepository.save(new Topico(topicoDatos));
    }

    @PutMapping()
    @Transactional
    public void actualizarTopico(@RequestBody @Valid TopicoDatosAActualizar topicoDatosAActualizar) {
        Topico topico = topicoRepository.getReferenceById(topicoDatosAActualizar.id());
        topico.actualizarDatos(topicoDatosAActualizar);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
//      topicoRepository.delete(topico);
        topico.desactivarTopico();
    }


}
