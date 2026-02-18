package com.bebidas.controller;

import com.bebidas.model.*;
import com.bebidas.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final BebidaRepository bebidaRepository;

    public PedidoController(PedidoRepository pedidoRepository,
                            ClienteRepository clienteRepository,
                            BebidaRepository bebidaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.bebidaRepository = bebidaRepository;
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @PostMapping
    public Pedido salvar(@RequestBody PedidoRequest request) {

        Cliente cliente = clienteRepository.findById(request.getClienteId()).orElseThrow();
        Bebida bebida = bebidaRepository.findById(request.getBebidaId()).orElseThrow();

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setBebida(bebida);
        pedido.setQuantidade(request.getQuantidade());

        double total = bebida.getPreco() * request.getQuantidade();
        pedido.setTotal(total);

        return pedidoRepository.save(pedido);
    }
}
