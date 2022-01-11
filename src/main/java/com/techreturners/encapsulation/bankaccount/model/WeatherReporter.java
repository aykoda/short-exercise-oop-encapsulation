package com.techreturners.encapsulation.bankaccount.model;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class WeatherReporter {

    private  final String LOCATION;
    private  final double TEMPERATURE;
    private  Map<String,Double> dbTemparatures;

    public WeatherReporter(String location)//, double temperature)
    {
        this.LOCATION = location;
        this.TEMPERATURE = TemperatureByCelsius();
    }

    public double TemperatureByFahrenheit(){
        return (9.0 / 5.0) * TEMPERATURE + 32;
    }

    public String WeatherReporterbyFahrenheit() {
        return "The temperature in Fahrenheit is " + TemperatureByFahrenheit();
    }

    public double TemperatureByCelsius(){
        dbTemparatures = new HashMap<String,Double>();
        dbTemparatures.put("London",10.0);
        dbTemparatures.put("California",30.0);
        dbTemparatures.put("Cape Town",40.0);

        //connect to DB or API and take the current temperature value by location
        // dbTemparatures = connectDBWeather(LOCATION);
        return dbTemparatures.get(LOCATION);
    }
    public String WeatherReporterbyCelsius() {
        return "The temperature in Celsius is "+TEMPERATURE ;
    }

    private String TouristicTemperature() {

        if (TEMPERATURE > 30) {
            return "It's too hot!";
        } else if (TEMPERATURE < 10) {
            return "It's too cold!";
        }
        return  "Ahhh...it's just right!";
    }

    public String WeatherTouristicReporter(){
        return MessageFormat.format("The weather prediction for {0} is {1}. {2} {3} {4}",
                LOCATION,
                TEMPERATURE,
                TouristicTemperature(),
                WeatherReporterbyCelsius(),
                WeatherReporterbyFahrenheit());
    }

}
