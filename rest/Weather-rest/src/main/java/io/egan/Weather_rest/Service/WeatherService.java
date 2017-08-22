package io.egan.Weather_rest.Service;

import java.util.List;

import io.egan.Weather_rest.Entity.Weather;

public interface WeatherService {

	public List<Weather> findAll();

	public Weather findById(String id);

	public List<String> findCities();

	public Weather findLatestCityWeather(String city);

	public String findLatestWeatherProperty(String city, String param);

	public Weather dailyAveragedWeather(String city, String date);

	public Weather createWeatherData(Weather weather);

	public Weather updateWeather(String id, Weather weather);

	public void deleteWeather(String id);
}
