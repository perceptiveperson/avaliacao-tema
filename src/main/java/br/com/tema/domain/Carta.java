package br.com.tema.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.tema.enums.Classe;
import br.com.tema.enums.Tipo;
import br.com.tema.exception.CartaInvalidaException;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@Entity
public class Carta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomeCarta;
	private String descricaoCarta;
	private int ataqueCarta;
	private int defesaCarta;
	private Tipo tipoCarta;
	private Classe classeCarta;
	
	private boolean isValid(int ataqueCarta) {
		return ataqueCarta >= 0 && ataqueCarta <=10 ? true : false;
	}

	public void setAtaqueCarta(int ataque) throws CartaInvalidaException {
		if (isValid(ataque)) {
			this.ataqueCarta = ataque;		
		} else
			throw new CartaInvalidaException("Valor inválido. Permitido valores de 0 a 10 para Ataque e Defesa.");
	}

}
