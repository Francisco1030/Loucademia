package br.com.loucademia.application.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.Validation;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.aluno.AlunoRepository;
import br.com.loucademia.domain.aluno.Aluno.Situacao;

@Stateless
public class AlunoService {

	@EJB
	private AlunoRepository alunoRepository;

	public void createOrUpdate(Aluno aluno) {
		if (StringUtils.isEmpty(aluno.getMatricula())) {
			create(aluno);
		} else {
			update(aluno);
		}
	}

	public void create(Aluno aluno) {
		Validation.assertNotEmpty(aluno);
		String maxMatricula = alunoRepository.getMaxMatriculaAno();
		aluno.gererMatricula(maxMatricula);
		alunoRepository.store(aluno);
	}

	public void update(Aluno aluno) {
		Validation.assertNotEmpty(aluno);
		Validation.assertNotEmpty(aluno.getMatricula());
		alunoRepository.update(aluno);
	}

	public void delete(String matricula) {
		alunoRepository.delete(matricula);
	}

	public Aluno findByMatricula(String matricula) {
		return alunoRepository.findByMatricula(matricula);
	}

	public List<Aluno> listaAlunos(String matricula, String nome, Integer rg, Integer telefone) {
		if(StringUtils.isEmpty(matricula) && StringUtils.isEmpty(nome) && rg == null && telefone == null) {
			throw new ValidationException("Pelo menos um campo de ver preechido");
		}
		return alunoRepository.listaAlunos(matricula, nome, rg, telefone);
	}
	
	public List<Aluno> listaSituacaoAlunos(Situacao situacao){
		Validation.assertNotEmpty(situacao);
		return alunoRepository.listaSituacaoAlunos(situacao);
	}

}
