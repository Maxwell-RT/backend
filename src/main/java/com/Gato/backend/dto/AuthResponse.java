package com.Gato.backend.dto;

import java.util.List;

public record AuthResponse(
        String token,
        String nombre,
        String correo,
        List<String> roles
) {}