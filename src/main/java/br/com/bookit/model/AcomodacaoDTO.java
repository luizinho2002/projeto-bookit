package br.com.bookit.model;

import java.math.BigDecimal;

public record AcomodacaoDTO (
    Long id,
    String nome,
    String cidade,
    BigDecimal precoDiaria 
) {}
 