package br.com.fiap.SistemaDeTorneio.controller;

import br.com.fiap.SistemaDeTorneio.dto.PlayerDTO;
import br.com.fiap.SistemaDeTorneio.model.Player;
import br.com.fiap.SistemaDeTorneio.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> listarTodos() {
        return ResponseEntity.ok(playerService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Player> criar(@RequestBody PlayerDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> atualizar(@PathVariable Long id, @RequestBody PlayerDTO dto) {
        return ResponseEntity.ok(playerService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        playerService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}