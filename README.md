Weather_Rest is a Java application developed in Spring framework and include REST operations. It also make use of Swagger UI for documentation.
![swagger_homescreen](https://user-images.githubusercontent.com/17698773/29547505-214fd586-86af-11e7-9d71-591bd50e6f9e.png)


It Includes:
1. A REST endpoint that create JSON and stores it in MYSQL Database.
![create_json](https://user-images.githubusercontent.com/17698773/29548080-ef51a6e6-86b2-11e7-8340-397360d6c4de.png)


2. Rest Endpoint to fetch data
2.1. Endpoint to fetch all the data with http://localhost:8080/Weather-rest/api/weather/
![json_fetch_all](https://user-images.githubusercontent.com/17698773/29547499-21360f5c-86af-11e7-9d69-ec589f014043.png)
![postman_json_get_all](https://user-images.githubusercontent.com/17698773/29547504-214fa3a4-86af-11e7-96b3-e24581a651a5.png)


2.2. Endpoint to fetch data at specific id http://localhost:8080/Weather-rest/api/weather/WP1AB29P54LA60180
![json_specific_id](https://user-images.githubusercontent.com/17698773/29547496-213550d0-86af-11e7-9963-aeb01d9f3bdc.png)
![json_specific_id](https://user-images.githubusercontent.com/17698773/29547498-21358f5a-86af-11e7-899a-dd4646a7043f.png)


2.3. Endpoint to fetch the list of all the cities http://localhost:8080/Weather-rest/api/weather/cities
![get_list_of_cities](https://user-images.githubusercontent.com/17698773/29547500-21363b9e-86af-11e7-879d-4274019893b2.png)


2.4. Endpoint to return latest pressure data for prticular city http://localhost:8080/Weather-rest/api/weather/latest/chicago/pressure
![latest_city_property humidity](https://user-images.githubusercontent.com/17698773/29547506-2151ceae-86af-11e7-90bd-029b6c683a9d.png)


2.5. Endpoint to return latest temperature for particular city http://localhost:8080/Weather-rest/api/weather/latest/chicago/temperature
![latest_city_property temperature](https://user-images.githubusercontent.com/17698773/29547502-214f8dce-86af-11e7-9542-623653caffc0.png)


2.6. Endpoint to return latest weather of a given city http://localhost:8080/Weather-rest/api/weather/city/chicago
![latest_city_weather](https://user-images.githubusercontent.com/17698773/29547503-214fb5a6-86af-11e7-8024-db60dc02cd0e.png)


2.7. Endpoint to return the average on particular date or day http://localhost:8080/Weather-rest/api/weather/daily/chicago/2017-01-11
![average_on_particular_day](https://user-images.githubusercontent.com/17698773/29547497-21352f92-86af-11e7-89d9-2631ccdb7f48.png)


2.8. Endpoint to update the JSON on particular id http://localhost:8080/Weather-rest/api/weather/WP1AB29P63LA60181
![update_json](https://user-images.githubusercontent.com/17698773/29547507-2151ff14-86af-11e7-8a3b-feed63ea9876.png)


2.9. Endpoint to delete the JSON for particular id
![delete](https://user-images.githubusercontent.com/17698773/29547501-213a7876-86af-11e7-8b35-2d123aa5f26f.png)



How to run the code?
1. In order to run with swagger UI. Download the code and go to ServletInitializer.java file and change Servlet Mapping from "/api/*" to "/*"
2. In order to run the code without swagger UI. just run the code with servlet mapping "/api/*"
