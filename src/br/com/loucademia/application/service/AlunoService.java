package br.com.loucademia.application.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.Validation;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.aluno.AlunoRepository;

@Stateless
public class AlunoService {
	
	@EJB
	private AlunoRepository alunoRepository;
	
	public void createOrUpdate(Aluno aluno) {
		if(StringUtils.isEmpty(aluno.getMatricula())) {
			create(aluno);
		}else {
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
	
	public Aluno findByMatricula(String matricula) {
		return alunoRepository.findByMatricula(matricula);
	}
}
