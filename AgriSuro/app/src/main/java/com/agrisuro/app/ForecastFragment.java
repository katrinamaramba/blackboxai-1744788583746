package com.agrisuro.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForecastFragment extends Fragment {

    public ForecastFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);

        LinearLayout forecastContainer = view.findViewById(R.id.forecastContainer);

        // Mock data for forecast days
        String[] days = {"Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] conditions = {"Sunny", "Cloudy", "Rainy", "Rainy", "Cloudy", "Sunny"};
        int[] highTemps = {33, 31, 29, 28, 30, 32};
        int[] lowTemps = {26, 25, 24, 24, 25, 26};
        int[] rainfalls = {0, 0, 15, 25, 5, 0};

        for (int i = 0; i < days.length; i++) {
            View dayView = inflater.inflate(R.layout.item_forecast_day, forecastContainer, false);

            TextView dayText = dayView.findViewById(R.id.dayText);
            TextView conditionText = dayView.findViewById(R.id.conditionText);
            TextView highTempText = dayView.findViewById(R.id.highTempText);
            TextView lowTempText = dayView.findViewById(R.id.lowTempText);
            TextView rainfallText = dayView.findViewById(R.id.rainfallText);

            dayText.setText(days[i]);
            conditionText.setText(conditions[i]);
            highTempText.setText(highTemps[i] + "°");
            lowTempText.setText(lowTemps[i] + "°");
            rainfallText.setText(rainfalls[i] + " mm");

            forecastContainer.addView(dayView);
        }

        return view;
    }
}
