package io.egan.Weather_rest.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@NamedQueries({ @NamedQuery(name = "Weather.findAll", query = "SELECT e from Weather e"),
		@NamedQuery(name = "Weather.findByid", query = "SELECT e from Weather e where e.weatherId=:pid"),
		@NamedQuery(name = "Weather.findCities", query = "SELECT DISTINCT e.city from Weather e ORDER BY e.city ASC"),
		@NamedQuery(name = "Weather.findLatestCityWeather", query = "SELECT e from Weather e where e.city=:pcity ORDER BY e.timestamp DESC"),
		@NamedQuery(name = "WeatherDetails.dailyAverageweather", query = "SELECT e from Weather e where e.city=:pcity and date(e.timestamp)=:day")

})
public class Weather {

	@Id
	private String weatherId;
	private String city;
	private String description;
	private String humidity;
	private String pressure;
	private String temperature;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date timestamp;

	@OneToOne(cascade = { CascadeType.ALL })
	private Wind wind;

	public Weather() {
		this.weatherId = UUID.randomUUID().toString();
	}

	public Weather(String temperature, String humidity) {
		this.temperature = temperature;
		this.humidity = humidity;
	}

	public String getWeatherId() {
		return weatherId;
	}

	public void setWeatherId(String weatherId) {
		this.weatherId = weatherId;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Weather [weatherId=" + weatherId + ", city=" + city + ", description=" + description + ", humidity="
				+ humidity + ", pressure=" + pressure + ", temperature=" + temperature + ", timestamp=" + timestamp
				+ ", wind=" + wind + "]";
	}

}
