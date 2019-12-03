package br.usjt.clima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.clima.model.Clima;

public interface PrevisaoRepository extends JpaRepository<Clima, Long> {

}
