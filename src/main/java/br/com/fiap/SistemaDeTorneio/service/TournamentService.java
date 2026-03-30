package br.com.fiap.SistemaDeTorneio.service;

import br.com.fiap.SistemaDeTorneio.dto.TournamentDTO;
import br.com.fiap.SistemaDeTorneio.model.Tournament;
import br.com.fiap.SistemaDeTorneio.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public List<Tournament> listarTodos() {
        return tournamentRepository.findAll();
    }

    public Tournament buscarPorId(Long id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Torneio não encontrado com id: " + id));
    }

    public Tournament criar(TournamentDTO dto) {
        Tournament tournament = new Tournament();
        tournament.setNome(dto.getNome());
        tournament.setJogo(dto.getJogo());
        tournament.setDataInicio(dto.getDataInicio());
        tournament.setDataFim(dto.getDataFim());
        tournament.setStatus(dto.getStatus());
        tournament.setPremiacao(dto.getPremiacao());
        return tournamentRepository.save(tournament);
    }

    public Tournament atualizar(Long id, TournamentDTO dto) {
        Tournament tournament = buscarPorId(id);
        tournament.setNome(dto.getNome());
        tournament.setJogo(dto.getJogo());
        tournament.setDataInicio(dto.getDataInicio());
        tournament.setDataFim(dto.getDataFim());
        tournament.setStatus(dto.getStatus());
        tournament.setPremiacao(dto.getPremiacao());
        return tournamentRepository.save(tournament);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        tournamentRepository.deleteById(id);
    }
}