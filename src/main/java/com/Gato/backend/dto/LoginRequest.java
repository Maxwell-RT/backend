package com.Gato.backend.dto;

public record LoginRequest(
        String correo,
        String password
) {}