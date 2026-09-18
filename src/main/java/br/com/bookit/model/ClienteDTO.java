package br.com.bookit.model;

public record ClienteDTO (
    String cpf,
    String nome,
    String email
) {}
