package br.com.bookit.model;

import java.time.LocalDate;

public record Reserva (
    Long id,
    ClienteDTO cliente,
    AcomodacaoDTO acomodacao,
    LocalDate dataInicio,
    LocalDate dataFim
) {}
