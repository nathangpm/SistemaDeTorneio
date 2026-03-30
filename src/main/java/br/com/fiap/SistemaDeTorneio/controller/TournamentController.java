package br.com.fiap.SistemaDeTorneio.controller;

import br.com.fiap.SistemaDeTorneio.dto.TournamentDTO;
import br.com.fiap.SistemaDeTorneio.model.Tournament;
import br.com.fiap.SistemaDeTorneio.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    public ResponseEntity<List<Tournament>> listarTodos() {
        return ResponseEntity.ok(tournamentService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tournamentService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Tournament> criar(@RequestBody TournamentDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tournamentService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tournament> atualizar(@PathVariable Long id, @RequestBody TournamentDTO dto) {
        return ResponseEntity.ok(tournamentService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tournamentService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}