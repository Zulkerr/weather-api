package com.example.weather_api;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final List<WeatherData> weatherDataList = new ArrayList<>();

    @PostMapping
    public String addWeatherData(@RequestBody WeatherData data) {
        weatherDataList.add(data);
        return "Wetterdaten für " + data.city() + " erfolgreich gespeichert!";

    }

    @GetMapping("/{city}")
    public List<WeatherData> getWeatherByCity(@PathVariable String city){
        return weatherDataList.stream()
                .filter(data -> data.city().equalsIgnoreCase(city))
                .toList();
    }
}
