package br.usjt.clima.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import br.usjt.clima.core.Forecast;
import br.usjt.clima.core.Previsao;
import br.usjt.clima.model.Cidade;
import br.usjt.clima.model.Clima;
import br.usjt.clima.repository.PrevisaoRepository;
import br.usjt.clima.repository.SemanaRepository;

@Service @ResponseBody
public class PrevisaoService {
	@Autowired
	SemanaRepository semanaRepo;
	
	@Autowired
	PrevisaoRepository previsaoRepo;
	
	private final String URL_PREV = "https://samples.openweathermap.org/data/2.5/forecast?q=";
	private final String APP_ID = "be8b5a409db5a652138d22f3a50368f9";
	private final double TO_CELSIUS = 273.15;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private String urlPrev(String city) {
		return URL_PREV + city + "&appid=" + APP_ID;
	}

	public Forecast obter(Cidade cidade) {
		RestTemplate restTemplate = new RestTemplate();
		Forecast prev = restTemplate.getForObject(urlPrev(cidade.getNome()), Forecast.class);
		return prev;
	}

	public String raw() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(urlPrev("Sao%20Paulo,br"), String.class);
	}
	
	private int diaSemana(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public List<Clima> toClimaList(Forecast forecast, Cidade cidade) {
		List<Clima> climas = new ArrayList<>();
		for (Previsao previsao : forecast.getPrevisoes()) {
			Date data = new Date(1000 * previsao.getDt());
			Clima c = new Clima(null, semanaRepo.findById(Long.valueOf(diaSemana(data))).get(), data, 
					previsao.getTemperature().getTempMin() - TO_CELSIUS, 
					previsao.getTemperature().getTempMax() - TO_CELSIUS, previsao.getTemperature().getHumidity(), 
					previsao.getWeathers().get(0).getDescription(), previsao.getWeathers().get(0).getIcon(), cidade);
			climas.add(c);		
		}
		return climas;
	}

	public void saveClimas(List<Clima> climas) {
		climas.forEach(c -> previsaoRepo.save(c));
	}

}
