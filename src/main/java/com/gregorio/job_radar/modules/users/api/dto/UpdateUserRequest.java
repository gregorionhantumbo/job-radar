package com.gregorio.job_radar.modules.users.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record UpdateUserRequest(
    @NotBlank(message = "O nome completo é obrigatório.")
    @Size(max = 150, message = "O nome completo não pode exceder 150 caracteres.")
    String fullName,

    @NotBlank(message = "O username é obrigatório.")
    @Size(min = 3, max = 50, message = "O username deve ter entre 3 e 50 caracteres.")
    @Pattern(
            regexp = "^[a-zA-Z0-9._-]+$",
            message = "O username contém caracteres inválidos."
    )
    String username,

    @Size(max = 25, message = "O contacto não pode exceder 25 caracteres.")
    @Pattern(
            regexp = "^\\+?[0-9() .-]*$",
            message = "O contacto contém caracteres inválidos."
    )
    String contact,

    @Size(max = 150, message = "O título não pode exceder 150 caracteres.")
    String title,

    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email não tem um formato válido.")
    @Size(max = 254, message = "O email não pode exceder 254 caracteres.")
    String email,

    @NotNull(message = "A lista de skills é obrigatória.")
    @Size(max = 50, message = "Não podes enviar mais de 50 skills.")
    Set<
            @NotBlank(message = "O nome de uma skill não pode estar vazio.")
            @Size(max = 80, message = "O nome de uma skill não pode exceder 80 caracteres.")
                    String
            > skills
    ) {
}
