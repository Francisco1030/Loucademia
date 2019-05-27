package br.com.loucademia.interfaces.aluno.web;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.util.List;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.application.service.AlunoService;

@Named
@SessionScoped
public class PesquisaAlunoBean {
	
	@EJB
	private AlunoService alunoService;
	
	private String matricula;
	private String nome;
	private Integer rg;
	private Integer telefone;
	
	private List<Aluno> alunos;
	

	public String pesquisar() {
		alunos = alunoService.listaAlunos(matricula, nome, rg, telefone);
		return null;
	}
	
	public String excluir(String matricula) {
		alunoService.delete(matricula);
		return pesquisar();
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getRg() {
		return rg;
	}
	public void setRg(Integer rg) {
		this.rg = rg;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}

}
