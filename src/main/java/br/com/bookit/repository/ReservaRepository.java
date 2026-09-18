package br.com.bookit.repository;

import br.com.bookit.model.Reserva;
import java.util.HashSet;
import java.util.Set;
import java.util.Optional;

public class ReservaRepository {
    
    // Armazenamento em memória (garante elementos únicos via Set)
    private final Set<Reserva> reservas = new HashSet<>();

    // Salva uma nova reserva
    public void salvar(Reserva reserva) {
        reservas.add(reserva);
    }

    // Retorna todas as reservas salvas
    public Set<Reserva> buscarTodas() {
        return new HashSet<>(reservas); // Retorna uma cópia para proteger a coleção original
    }

    // Busca uma reserva pelo ID
    public Optional<Reserva> buscarPorId(Long id) {
        return reservas.stream()
            .filter(reserva -> reserva.id().equals(id))
            .findFirst();
    }
}
