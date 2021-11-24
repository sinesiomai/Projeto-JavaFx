package entities;

import java.sql.Date;
import java.util.Objects;

public class Vendedor {
	private Integer id;
	private String nome;
	private String email;
	private Date DtNasc;
	private Double salario;

	private Departamento departamento;

	public Vendedor() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtNasc() {
		return DtNasc;
	}

	public void setDtNasc(Date DtNasc) {
		this.DtNasc = DtNasc;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DtNasc, departamento, email, id, nome, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedor other = (Vendedor) obj;
		return Objects.equals(DtNasc, other.DtNasc) && Objects.equals(departamento, other.departamento)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(salario, other.salario);
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", nome=" + nome + ", email=" + email + ", datansc=" + DtNasc + ", salario="
				+ salario + ", departamento=" + departamento + "]";
	}

}