package com.entronomia.aplicaciones.foro.dto;

import com.entronomia.aplicaciones.foro.model.Topico;

public record TopicoDatosAMostrar(
        Long id,
        String titulo,
        String mensaje,
        String fecha
) {
    public TopicoDatosAMostrar(Topico t) {
        this(t.getId(), t.getTitulo(), t.getMensaje(), t.getFecha());
    }
}
