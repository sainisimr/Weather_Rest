package io.egan.Weather_rest.WeatherServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egan.Weather_rest.Entity.Weather;
import io.egan.Weather_rest.Exception.NotFoundException;
import io.egan.Weather_rest.Service.WeatherService;
import io.egan.Weather_rest.WeatherRepository.WeatherRepository;

@Service
public class WeatherServiceImpl implements WeatherService {

	private WeatherRepository repository;

	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Weather> findAll() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Weather findById(String id) {
		Weather existing = repository.findById(id);
		if (existing == null) {
			throw new NotFoundException("Weather for the city with ID: " + id + " doesn't exist");
		}
		return existing;
	}

	@Transactional(readOnly = true)
	@Override
	public List<String> findCities() {
		return repository.findCities();
	}

	@Transactional(readOnly = true)
	@Override
	public Weather findLatestCityWeather(String city) {
		Weather existing = repository.findLatestCityWeather(city);
		if (existing == null) {
			throw new NotFoundException("Weather for the city: " + city + " doesn't exist");
		}
		return existing;
	}

	@Transactional(readOnly = true)
	@Override
	public String findLatestWeatherProperty(String city, String param) {
		String existing = repository.findLatestWeatherProperty(city, param);
		if (existing == null) {
			throw new NotFoundException("Weather parameter: " + param + "for the city: " + city + " doesn't exist");
		}
		return existing;
	}

	@Transactional
	@Override
	public Weather createWeatherData(Weather weather) {
		return repository.createWeatherData(weather);
	}

	@Transactional(readOnly = true)
	@Override
	public Weather dailyAveragedWeather(String city, String date) {
		return repository.dailyAveragedWeather(city, date);
	}

	@Transactional
	@Override
	public Weather updateWeather(String id, Weather weather) {
		Weather existing = repository.findById(id);
		if (existing == null) {
			throw new NotFoundException("Weather for the city with id: " + id + " doesn't exist");
		}
		return repository.updateWeather(weather);

	}

	@Transactional
	@Override
	public void deleteWeather(String id) {
		Weather existing = repository.findById(id);
		if (existing == null) {
			throw new NotFoundException("Weather for the city with id: " + id + " doesn't exist");
		}
		repository.deleteWeather(existing);

	}

}
