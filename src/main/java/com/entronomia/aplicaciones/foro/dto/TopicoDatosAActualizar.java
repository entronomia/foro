package com.entronomia.aplicaciones.foro.dto;

import jakarta.validation.constraints.NotNull;

public record TopicoDatosAActualizar(@NotNull Long id, String mensaje, String fecha) {
}
