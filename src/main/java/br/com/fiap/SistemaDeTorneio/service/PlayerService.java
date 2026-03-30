package br.com.fiap.SistemaDeTorneio.service;

import br.com.fiap.SistemaDeTorneio.dto.PlayerDTO;
import br.com.fiap.SistemaDeTorneio.model.Player;
import br.com.fiap.SistemaDeTorneio.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> listarTodos() {
        return playerRepository.findAll();
    }

    public Player buscarPorId(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player não encontrado com id: " + id));
    }

    public Player criar(PlayerDTO dto) {
        Player player = new Player();
        player.setNickname(dto.getNickname());
        player.setNome(dto.getNome());
        player.setEmail(dto.getEmail());
        player.setPontuacao(dto.getPontuacao());
        player.setDataCadastro(dto.getDataCadastro());
        return playerRepository.save(player);
    }

    public Player atualizar(Long id, PlayerDTO dto) {
        Player player = buscarPorId(id);
        player.setNickname(dto.getNickname());
        player.setNome(dto.getNome());
        player.setEmail(dto.getEmail());
        player.setPontuacao(dto.getPontuacao());
        player.setDataCadastro(dto.getDataCadastro());
        return playerRepository.save(player);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        playerRepository.deleteById(id);
    }
}