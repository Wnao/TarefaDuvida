package br.usjt.clima.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;

import br.usjt.clima.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> 
{
	public Cidade findOneByLatitudeAndLongitude(Double latitude, Double longitude);
//	public List<Cidade> findByNomeContainingIgnoreCase(String nome);
	
	@Async
	public Future<List<Cidade>> findByNome(String nome);
	
	public Cidade findByLatitudeAndLongitude (Double latitude, Double longitude); 
	
//	@Query ("SELECT c FROM Cidade c WHERE c.nome = :nome")
//	public Cidade findByNome1 (String nome);
//	
	@Query ("SELECT c FROM Cidade c WHERE c.nome LIKE :nome%")
	public List<Cidade> buscaByNomeIgnoreCase (String nome);
}
