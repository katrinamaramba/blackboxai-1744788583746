package com.agrisuro.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CurrentWeatherFragment extends Fragment {

    private TextView dateText, temperatureText, conditionText, humidityText, rainfallText, windSpeedText, lastUpdatedText;
    private ImageView weatherIcon;

    public CurrentWeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);

        dateText = view.findViewById(R.id.dateText);
        temperatureText = view.findViewById(R.id.temperatureText);
        conditionText = view.findViewById(R.id.conditionText);
        humidityText = view.findViewById(R.id.humidityText);
        rainfallText = view.findViewById(R.id.rainfallText);
        windSpeedText = view.findViewById(R.id.windSpeedText);
        lastUpdatedText = view.findViewById(R.id.lastUpdatedText);
        weatherIcon = view.findViewById(R.id.weatherIcon);

        // Mock data
        dateText.setText("Monday, June 10, 2023");
        temperatureText.setText("32°C");
        conditionText.setText("Sunny");
        humidityText.setText("75%");
        rainfallText.setText("0 mm");
        windSpeedText.setText("8 km/h");
        lastUpdatedText.setText("Just Now");
        weatherIcon.setImageResource(R.drawable.ic_sunny); // You need to add this drawable

        return view;
    }
}
