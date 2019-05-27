package br.com.loucademia.interfaces.aluno.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Aluno;

@Named
@RequestScoped //Faz com que o objeto só exista no tempo de submissão
public class AlunoBean implements Serializable{

	@EJB
	private AlunoService alunoService;
	
	@Inject
	private FacesContext facesContext;
	
	private Aluno aluno = new Aluno();
	
	private String titulo = "Novo aluno";
	
	private String matricula;
	
	public void carregar() {
		if(!StringUtils.isEmpty(matricula)) {
			aluno = alunoService.findByMatricula(matricula);
			this.titulo = "Alterar aluno";
		}
	}
	
	public String gravar() {
		alunoService.createOrUpdate(aluno);
		facesContext.addMessage(null, new FacesMessage("Dados gravados com sucesso"));
		return null;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getTitulo() {
		return titulo;
	}
	

}
