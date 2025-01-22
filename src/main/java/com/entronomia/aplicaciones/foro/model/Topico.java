package com.entronomia.aplicaciones.foro.model;

import com.entronomia.aplicaciones.foro.category.Tema;
import com.entronomia.aplicaciones.foro.dto.TopicoDatos;
import com.entronomia.aplicaciones.foro.dto.TopicoDatosAActualizar;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;

@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Tema tema;
    private String mensaje;
    private String fecha;
    private Boolean activo;

    public Topico() {
    }

    public Topico(String usuario, String titulo, Tema tema, String mensaje, String fecha) {
        this.activo = true;
        this.usuario = usuario;
        this.titulo = titulo;
        this.tema = tema;
        this.mensaje = mensaje;
        this.fecha = fecha;
    }

    public Topico(TopicoDatos topicoDatos) {
        this.activo = true;
        this.usuario = topicoDatos.idUsuario();
        this.titulo = topicoDatos.titulo();
        this.tema = topicoDatos.tema();
        this.mensaje = topicoDatos.mensaje();
        this.fecha = topicoDatos.fecha();
    }

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public Tema getTema() {
        return tema;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void actualizarDatos(@Valid TopicoDatosAActualizar topicoDatosAActualizar) {
        if (topicoDatosAActualizar.mensaje() != null) {
            this.mensaje = topicoDatosAActualizar.mensaje();
        }
        if (topicoDatosAActualizar.fecha() != null) {
            this.fecha = topicoDatosAActualizar.fecha();
        }
    }

    public void desactivarTopico() {
        this.activo = false;
    }
}

