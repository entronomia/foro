package com.entronomia.aplicaciones.foro.dto;

import com.entronomia.aplicaciones.foro.category.Tema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoDatos(
        @NotBlank
        String idUsuario,
        @NotBlank
        String titulo,
        @NotNull
        Tema tema,
        @NotBlank
        String mensaje,
        @NotBlank
        String fecha
) {
}
