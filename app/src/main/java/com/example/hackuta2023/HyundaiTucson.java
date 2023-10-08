package com.example.hackuta2023;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HyundaiTucson extends AppCompatActivity {
    private int miles, year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bundle bundle = getIntent().getExtras();
        miles = getIntent().getExtras().getInt("miles");
        year = getIntent().getExtras().getInt("year");
        setContentView(R.layout.hyundai_tucson);

        // Create an array of ToyotaCamry objects with years from 2019 to 2023
        CarInfo[] toyotaCamryArray = {
                new CarInfo(2019, 3000, 3, 40000),
                new CarInfo(2020, 3500, 3, 45000),
                new CarInfo(2021, 4500, 4, 50000),
                new CarInfo(2022, 5000, 5, 55000),
                new CarInfo(2023, 5000, 5, 60000)
        };

        performMaintenance(year, miles, toyotaCamryArray);
    }

    // Define a class to represent the car information
    private class CarInfo {
        private int year;
        private int oilChangeMiles;
        private int batteryChangeYear;
        private int tireChangeMiles;

        public CarInfo(int year, int oilChangeMiles, int batteryChangeYear, int tireChangeMiles) {
            this.year = year;
            this.oilChangeMiles = oilChangeMiles;
            this.batteryChangeYear = batteryChangeYear;
            this.tireChangeMiles = tireChangeMiles;
        }

        public int getYear() {
            return year;
        }

        public int getOilChangeMiles() {
            return oilChangeMiles;
        }

        public int getBatteryChangeYear() {
            return batteryChangeYear;
        }

        public int getTireChangeMiles() {
            return tireChangeMiles;
        }
    }

    // Function to perform maintenance calculations
    private void performMaintenance(int year, int odometerMiles, CarInfo[] toyotaCamryArray) {
        int expectedOilChangeMiles = 0;
        int expectedBatteryChangeYear = 0;
        int expectedTireChangeMiles = 0;

        // Find the car's information based on the year
        for (CarInfo carInfo : toyotaCamryArray) {
            if (carInfo.getYear() == year) {
                expectedOilChangeMiles = carInfo.getOilChangeMiles() - odometerMiles;
                expectedBatteryChangeYear = year + carInfo.getBatteryChangeYear() - carInfo.getYear();
                expectedTireChangeMiles = carInfo.getTireChangeMiles() - odometerMiles;
                while(expectedBatteryChangeYear < 0){
                    expectedBatteryChangeYear += carInfo.getBatteryChangeYear();
                }
                while(expectedTireChangeMiles < 0){
                    expectedTireChangeMiles += carInfo.getTireChangeMiles();
                }
                while(expectedOilChangeMiles < 0){
                    expectedOilChangeMiles += carInfo.getOilChangeMiles();
                }
                break;
            }
        }


        // Find TextViews by their IDs
        TextView textViewYear = findViewById(R.id.textViewYear);
        TextView textViewOdometer = findViewById(R.id.textViewOdometer);
        TextView textViewOilChange = findViewById(R.id.textViewOilChange);
        TextView textViewBatteryChangeYear = findViewById(R.id.textViewBatteryChangeYear);
        TextView textViewTireChangeMiles = findViewById(R.id.textViewTireChangeMiles);

        // Update TextViews with the values using setText() and string resources
        textViewYear.setText(getString(R.string.year_of_the_car) + " " + String.valueOf(year));
        textViewOdometer.setText(getString(R.string.odometer_reading) + " " + String.valueOf(odometerMiles));
        textViewOilChange.setText(getString(R.string.expected_oil_change_miles) + " " + String.valueOf(expectedOilChangeMiles));
        textViewBatteryChangeYear.setText(getString(R.string.expected_year_for_battery_change) + " " + String.valueOf(expectedBatteryChangeYear));
        textViewTireChangeMiles.setText(getString(R.string.expected_tire_change_miles) + " " + String.valueOf(expectedTireChangeMiles));

    }
}
