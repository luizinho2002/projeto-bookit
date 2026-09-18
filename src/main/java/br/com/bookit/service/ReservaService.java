package br.com.bookit.service;

import br.com.bookit.repository.ReservaRepository;
import br.com.bookit.model.Reserva;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

public class ReservaService {
    
    // Guarda a referência do repositório para podermos utilizar os métodos de salvar e buscar
    private final ReservaRepository repository;

    // Construtor: recebe o repositório de fora e salva na variável acima (Injeção de Dependência)
    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    // 1. Salva a reserva delegando a responsabilidade para o repositório
    public void criarReserva(Reserva reserva) {
        repository.salvar(reserva);
    }

    // 2. Busca uma reserva por ID
    public Optional<Reserva> buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    // 3. Filtra reservas por CPF do cliente utilizando Stream API
    public List<Reserva> buscarPorCpfCliente(String cpf) {
        return repository.buscarTodas().stream()
                .filter(reserva -> reserva.cliente().cpf().equalsIgnoreCase(cpf))
                .collect(Collectors.toList());
    }
}
