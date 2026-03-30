package br.com.fiap.SistemaDeTorneio.repository;

import br.com.fiap.SistemaDeTorneio.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}