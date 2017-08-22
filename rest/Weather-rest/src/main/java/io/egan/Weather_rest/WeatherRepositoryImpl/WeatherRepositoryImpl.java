package io.egan.Weather_rest.WeatherRepositoryImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egan.Weather_rest.Entity.Weather;
import io.egan.Weather_rest.WeatherRepository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Weather> findAll() {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findAll", Weather.class);
		return query.getResultList();
	}

	@Override
	public Weather findById(String id) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findByid", Weather.class);
		query.setParameter("pid", id);
		List<Weather> list = query.getResultList();
		if (!list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<String> findCities() {
		TypedQuery<String> query = em.createNamedQuery("Weather.findCities", String.class);
		return query.getResultList();

	}

	@Override
	public Weather findLatestCityWeather(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findLatestCityWeather", Weather.class);
		query.setParameter("pcity", city);
		List<Weather> list = query.getResultList();
		return list.get(0);
	}

	@Override
	public String findLatestWeatherProperty(String city, String param) {
		Weather latest = findLatestCityWeather(city);
		if (latest != null) {
			if (param.equalsIgnoreCase("humidity")) {
				return city + ": " + latest.getHumidity();
			} else if (param.equalsIgnoreCase("pressure")) {
				return city + ": " + latest.getPressure();
			} else if (param.equalsIgnoreCase("temperature")) {
				return city + ": " + latest.getTemperature();
			}
		}

		return "Page Not Found. Search only available for the property of humidity, pressure and temperature.";
	}

	// TypedQuery<Double> query =
	// em.createNamedQuery("Weather.hourlyAveragedTemperature", Double.class);
	// query.setParameter("pcity", city);
	// Double temp1 = query.getSingleResult();
	// TypedQuery<Double> query1 =
	// em.createNamedQuery("Weather.hourlyAveragedHumidity", Double.class);
	// query1.setParameter("pcity", city);
	// Double temp2 = query1.getSingleResult();
	// TypedQuery<Double> query2 =
	// em.createNamedQuery("Weather.hourlyAveragedPressure", Double.class);
	// query2.setParameter("pcity", city);
	// Double temp3 = query2.getSingleResult();
	// return "Average Humidity: " + temp2 +"\r\n "+ "Average temperature: "+
	// temp1 +"\r\n "+ "Average Pressure: "+ temp3;

	@Override
	public Weather dailyAveragedWeather(String city, String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Weather averageWeather = null;
		Date supposed = null;
		try {
			supposed = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date dateSql = new java.sql.Date(supposed.getTime());
		TypedQuery<Weather> query = em.createNamedQuery("WeatherDetails.dailyAverageweather", Weather.class);
		query.setParameter("pcity", city);
		query.setParameter("day", dateSql);
		List<Weather> list = query.getResultList();
		if (!list.isEmpty()) {
			float averageTemp = 0, averageHum = 0, averagePres = 0;
			float total = list.size();
			averageWeather = new Weather();
			for (Weather weather : list) {
				averageTemp = averageTemp + Float.parseFloat(weather.getTemperature());
				averageHum = averageHum + Float.parseFloat(weather.getHumidity());
				averagePres = averagePres + Float.parseFloat(weather.getPressure());
			}
			averageWeather.setCity(city);
			averageWeather.setTimestamp(list.get(0).getTimestamp());
			averageWeather.setTemperature(String.format("%.2f", (averageTemp / total)));
			averageWeather.setHumidity(String.format("%.2f", (averageHum / total)));
			averageWeather.setPressure(String.format("%.2f", (averagePres / total)));
		}
		return averageWeather;
	}

	@Override
	public Weather createWeatherData(Weather weather) {
		em.persist(weather.getWind());
		em.persist(weather);
		return weather;
	}

	@Override
	public Weather updateWeather(Weather weather) {
		return em.merge(weather);

	}

	@Override
	public void deleteWeather(Weather weather) {
		em.remove(weather);

	}

}
