package br.com.loucademia.application.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.loucademia.domain.aluno.Estado;
import br.com.loucademia.domain.aluno.EstadoRepository;
import br.com.loucademia.domain.aluno.Aluno.Sexo;
import br.com.loucademia.domain.aluno.Aluno.Situacao;

@Stateless
public class DataService {
	
	@EJB
	private EstadoRepository estadoRepository;
	
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public Situacao[] getSituacoes() {
		return Situacao.values();
	}
	
	public List<Estado> listaEstados(){
		return estadoRepository.listaEstados();
	}

}
