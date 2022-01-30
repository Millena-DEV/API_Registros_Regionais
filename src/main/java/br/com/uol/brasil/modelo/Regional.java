package br.com.uol.brasil.modelo;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Regional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate dataCriacaoEstado;
	private LocalDate tempoCriacaoEstado;
	private String nomeCapital;
	@Enumerated(EnumType.STRING)
	private Regiao nomeRegiao= Regiao.NAO_RESPONDIDO;
	private String nomeEstado;
	private String populacao;
	private double area;

public Regional() {
	
}
	public Regional(String nomeCapital, String nomeEstado, Regiao nomeRegiao, double area, String populacao,
			LocalDate dataCriacaoEstado) {

		this.area = area;
		this.dataCriacaoEstado = dataCriacaoEstado;
		this.nomeCapital=nomeCapital;
		this.nomeEstado = nomeEstado;
		this.nomeRegiao= nomeRegiao;
	}



	public String getPopulacao() {
		return populacao;
	}

	public void sePopulacao(String populacao) {
		this.populacao = populacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDataCriacaoEstado() {
		return dataCriacaoEstado;
	}

	public void setDataCriacaoEstado(LocalDate dataCriacaoEstado) {
		this.dataCriacaoEstado = dataCriacaoEstado;
	}

	public double getArea() {
		return area;
	}

	public LocalDate getTempoCriacaoEstado() {
		return tempoCriacaoEstado;
	}

	public void setTempoCriacaoEstado(LocalDate tempoCriacaoEstado) {
		this.tempoCriacaoEstado = tempoCriacaoEstado;
	}

	public String getNomeCapital() {
		return nomeCapital;
	}

	public void setNomeCapital(String nomeCapital) {
		this.nomeCapital = nomeCapital;
	}

	public Regiao getNomeRegiao() {
		return nomeRegiao;
	}

	public void setNomeRegiao(Regiao nomeRegiao) {
		this.nomeRegiao = nomeRegiao;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	

	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataCriacaoEstado, id, nomeCapital, nomeEstado, nomeRegiao, tempoCriacaoEstado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Regional other = (Regional) obj;
		return Objects.equals(dataCriacaoEstado, other.dataCriacaoEstado) && id == other.id
				&& Objects.equals(nomeCapital, other.nomeCapital) && Objects.equals(nomeEstado, other.nomeEstado)
				&& Objects.equals(nomeRegiao, other.nomeRegiao)
				&& Objects.equals(tempoCriacaoEstado, other.tempoCriacaoEstado);
	}

}