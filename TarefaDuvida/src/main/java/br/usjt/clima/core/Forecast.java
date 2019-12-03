package br.usjt.clima.core;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Forecast {
	 private String cod;
	 private float message;
	 private float cnt;
	 @JsonAlias("list")
	 List<Previsao> previsoes;
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public float getMessage() {
		return message;
	}
	public void setMessage(float message) {
		this.message = message;
	}
	public float getCnt() {
		return cnt;
	}
	public void setCnt(float cnt) {
		this.cnt = cnt;
	}
	public List<Previsao> getPrevisoes() {
		return previsoes;
	}
	public void setPrevisoes(List<Previsao> previsoes) {
		this.previsoes = previsoes;
	}
	 
	 
}
