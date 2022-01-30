package br.com.uol.brasil.dto;


import java.time.LocalDate;
import java.util.Objects;


import org.springframework.data.domain.Page;


import br.com.uol.brasil.modelo.Regiao;
import br.com.uol.brasil.modelo.Regional;
public class RegionalDto {
	private long id;
	private String nomeCapital;
	private Regiao nomeRegiao;
	private String nomeEstado;
	private LocalDate dataCriacaoEstado;
	private LocalDate tempoCriacaoEstado; 
	private String populacao;
	private double area;
	
	public RegionalDto(Regional regional){
		this.id = regional.getId();
		this.dataCriacaoEstado= regional.getDataCriacaoEstado();
		this.tempoCriacaoEstado = regional.getTempoCriacaoEstado();
		this.nomeCapital= regional.getNomeCapital();
		this.nomeEstado= regional.getNomeEstado();
		this.nomeRegiao=regional.getNomeRegiao();
		this.populacao= regional.getPopulacao();
		this.area = regional.getArea();
	}




	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
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



	public LocalDate getDataCriacaoEstado() {
		return dataCriacaoEstado;
	}



	public void setDataCriacaoEstado(LocalDate dataCriacaoEstado) {
		this.dataCriacaoEstado = dataCriacaoEstado;
	}



	public LocalDate getTempoCriacaoEstado() {
		return tempoCriacaoEstado;
	}

	public void setTempoCriacaoEstado(LocalDate tempoCriacaoEstado) {
		this.tempoCriacaoEstado = tempoCriacaoEstado;
	}
	public String getPopulacao() {
		return populacao;
	}
	public void sePopulacao(String populacao) {
		this.populacao =populacao;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area =area;
	}


	public static Page<RegionalDto> converter(Page<Regional> regional) {
		return regional.map(RegionalDto::new);
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
		RegionalDto other = (RegionalDto) obj;
		return Objects.equals(dataCriacaoEstado, other.dataCriacaoEstado) && id == other.id
				&& Objects.equals(nomeCapital, other.nomeCapital) && Objects.equals(nomeEstado, other.nomeEstado)
				&& Objects.equals(nomeRegiao, other.nomeRegiao)
				&& Objects.equals(tempoCriacaoEstado, other.tempoCriacaoEstado);
	}

	
	

	
}
