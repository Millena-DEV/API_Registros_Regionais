package br.com.uol.brasil.form;

import java.time.LocalDate;

import br.com.uol.brasil.modelo.Regiao;
import br.com.uol.brasil.modelo.Regional;
import br.com.uol.brasil.repository.RegiaoRepository;

public class Regionalform {

	private String nomeCapital;

	private Regiao nomeRegiao;

	private String nomeEstado;

	private String populacao;

	private double area;
	private LocalDate dataCriacaoEstado;

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

	public String getPopulacao() {
		return populacao;
	}

	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public Regional converter() {

		return new Regional(nomeCapital, nomeEstado, nomeRegiao, area, populacao, dataCriacaoEstado);
	}

	public LocalDate getDataCriacaoEstado() {
		return dataCriacaoEstado;
	}

	public void setDataCriacaoEstado(LocalDate dataCriacaoEstado) {
		this.dataCriacaoEstado = dataCriacaoEstado;
	}

	
	
	public Regional atualizar(Long id, RegiaoRepository regiaoRepository) {
		Regional regional = regiaoRepository.getOne(id);
		regional.setNomeCapital(this.nomeCapital);
		regional.setNomeEstado(this.nomeEstado);
		regional.setNomeRegiao(this.nomeRegiao);
		regional.setArea(this.area);
		regional.setPopulacao(this.populacao);
		regional.setDataCriacaoEstado(this.dataCriacaoEstado);

		return regional;
	}

}
