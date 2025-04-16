package com.agrisuro.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WeatherFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    public WeatherFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(new WeatherPagerAdapter(this));

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Current Weather");
                            break;
                        case 1:
                            tab.setText("7-Day Forecast");
                            break;
                        case 2:
                            tab.setText("Recommendations");
                            break;
                    }
                }).attach();

        return view;
    }

    private static class WeatherPagerAdapter extends FragmentStateAdapter {

        public WeatherPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new CurrentWeatherFragment();
                case 1:
                    return new ForecastFragment();
                case 2:
                    return new RecommendationsFragment();
                default:
                    return new CurrentWeatherFragment();
            }
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}
