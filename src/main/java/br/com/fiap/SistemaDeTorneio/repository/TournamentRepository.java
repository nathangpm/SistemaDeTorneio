package br.com.fiap.SistemaDeTorneio.repository;

import br.com.fiap.SistemaDeTorneio.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}