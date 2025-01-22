package com.entronomia.aplicaciones.foro.repository;

import com.entronomia.aplicaciones.foro.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
