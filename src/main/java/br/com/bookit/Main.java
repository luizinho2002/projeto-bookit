package br.com.bookit;

import br.com.bookit.model.AcomodacaoDTO;
import br.com.bookit.model.ClienteDTO;
import br.com.bookit.model.Reserva;
import br.com.bookit.repository.ReservaRepository;
import br.com.bookit.service.ReservaService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializa o repositório e o serviço
        ReservaRepository repository = new ReservaRepository();
        ReservaService service = new ReservaService(repository);

        // 2. Cria os DTOs e a Reserva de teste
        ClienteDTO cliente1 = new ClienteDTO("123.456.789-00", "Luiz", "luiz@gmail.com");
        AcomodacaoDTO acomodacao1 = new AcomodacaoDTO(101L, "Chalé de Montanha", "CHALE", new BigDecimal("350.00"));

        Reserva reserva1 = new Reserva(
            1L,
            cliente1,
            acomodacao1,
            LocalDate.now(),
            LocalDate.now().plusDays(3)
        );

        // 3. Cadastra a reserva utilizando criarReserva
        service.criarReserva(reserva1);

        // 4. Executa a busca por CPF
        System.out.println("--- Testando Buscar por CPF ---");
        List<Reserva> reservasDoCliente = service.buscarPorCpfCliente("123.456.789-00");

        if (reservasDoCliente.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            reservasDoCliente.forEach(r -> {
                System.out.println("Reserva ID: " + r.id());
                System.out.println("Cliente: " + r.cliente().nome());
                System.out.println("Acomodação: " + r.acomodacao().nome());
                // Utilizando os métodos do record: dataInicio() e dataFim()
                System.out.println("Entrada: " + r.dataInicio() + " | Saída: " + r.dataFim());
            });
        }
    }
}
