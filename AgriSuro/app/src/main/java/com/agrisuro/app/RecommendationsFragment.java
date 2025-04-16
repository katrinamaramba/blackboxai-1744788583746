package com.agrisuro.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RecommendationsFragment extends Fragment {

    public RecommendationsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommendations, container, false);

        LinearLayout recommendationsContainer = view.findViewById(R.id.recommendationsContainer);

        // Mock data for recommendations
        String[] titles = {
            "Irrigation Alert",
            "Rainfall Expected",
            "Ideal Planting Conditions",
            "Heat Stress Warning"
        };

        String[] descriptions = {
            "High temperatures forecasted. Ensure adequate irrigation for the next 3 days.",
            "Prepare for moderate rainfall on Thursday and Friday. Consider delaying fertilizer application.",
            "Current weather conditions are optimal for seedling transplantation.",
            "High temperatures may cause heat stress. Monitor crops closely and increase water supply."
        };

        String[] priorities = {"High", "Medium", "Medium", "High"};

        for (int i = 0; i < titles.length; i++) {
            View recView = inflater.inflate(R.layout.item_recommendation, recommendationsContainer, false);

            TextView titleText = recView.findViewById(R.id.titleText);
            TextView descriptionText = recView.findViewById(R.id.descriptionText);
            TextView priorityText = recView.findViewById(R.id.priorityText);

            titleText.setText(titles[i]);
            descriptionText.setText(descriptions[i]);
            priorityText.setText(priorities[i] + " priority");

            recommendationsContainer.addView(recView);
        }

        return view;
    }
}
