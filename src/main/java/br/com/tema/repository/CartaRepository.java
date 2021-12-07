package br.com.tema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tema.domain.Carta;
import br.com.tema.enums.Classe;
import br.com.tema.enums.Tipo;

public interface CartaRepository extends JpaRepository<Carta, Integer> {
	
	List<Optional<Carta>> findByNomeCarta(String nome);
	
	List<Optional<Carta>> findByTipoCarta(Tipo nome);
	
	List<Optional<Carta>> findByClasseCarta(Classe nome);

}
