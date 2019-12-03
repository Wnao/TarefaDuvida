package br.usjt.clima.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Clima implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Semana semana;
	private Date dataHora;
	@JsonAlias("temp_min")
	private Double tempMin;
	@JsonAlias("temp_max")
	private Double tempMax;
	@JsonAlias("humidity")
	private Double umidade;
	private String descricao;
	private String iconName;
	
	
	
	
	
//	public Clima(Long id, Semana semana, Date dataHora, Double tempMin, Double tempMax, Double umidade,
//			String descricao, String iconName, Cidade cidade) {
//		super();
//		this.id = id;
//		this.semana = semana;
//		this.dataHora = dataHora;
//		this.tempMin = tempMin;
//		this.tempMax = tempMax;
//		this.umidade = umidade;
//		this.descricao = descricao;
//		this.iconName = iconName;
//		this.cidade = cidade;
//	}
//	
//	
//
//	public Clima() {
//		super();
//	}



	public String getIcone() {
		return "http://openweathermap.org/img/w/" + iconName + ".png";
		
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Semana getSemana() {
		return semana;
	}

	public void setSemana(Semana semana) {
		this.semana = semana;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Double getTempMin() {
		return tempMin;
	}

	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}

	public Double getTempMax() {
		return tempMax;
	}

	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}

	public Double getUmidade() {
		return umidade;
	}

	public void setUmidade(Double umidade) {
		this.umidade = umidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@JsonBackReference
	@ManyToOne
	Cidade cidade;
	
}
