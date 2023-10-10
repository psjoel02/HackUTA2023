package com.example.hackuta2023;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;

public class DesktopActivity extends AppCompatActivity {

    public EditText carType;

    private TextView changeText, odometer;
    private Button submitButton, secretButton;
    private int mileage, year;
    private String carModel, carMake;

    private String[] make = {"", "Chevrolet", "Ford", "Honda", "Hyundai", "Toyota"};
    private String[] modelChev = {"Model", "Impala", "Silverado"};

    private String[] modelFord = {"Model", "Explorer", "FSeries"};

    private String[] modelHonda = {"Model", "Accord", "Civic"};

    private String[] modelHyundai = {"Model", "Elantra", "Tuscan"};

    private String[] modelToyato = {"Model", "Camry", "Corolla"};



    private String[] modelEmpty = {"", "", "", "MIDI"};

    private String[] yearChoic = {"", "2019", "2020", "2021", "2022", "2023"};
    private Spinner makeSpinner, modelSpinner, yearCheck;

    private void intentCaller(String makeModel){
        Bundle bund = new Bundle();
        bund.putInt("miles", mileage);
        bund.putInt("year", year);
        Intent b;
        switch(makeModel){
            case "ToyotaCamry":
                b = new Intent(DesktopActivity.this, ToyotaCamry.class);
                break;
            case "ToyotaCorolla":
                b = new Intent(DesktopActivity.this, ToyotaCorolla.class);
                break;
            case "ChevroletImpala":
                b = new Intent(DesktopActivity.this, ChevroletImpala.class);
                break;
            case "ChevroletSilverado":
                b = new Intent(DesktopActivity.this, ChevroletSilverado.class);
                break;
            case "FordExplorer":
                b = new Intent(DesktopActivity.this, FordExplorer.class);
                break;
            case "FordFSeries":
                b = new Intent(DesktopActivity.this, FordFSeries.class);
                break;
            case "HondaAccord":
                b = new Intent(DesktopActivity.this, HondaAccord.class);
                break;
            case "HondaCivic":
                b = new Intent(DesktopActivity.this, HondaCivic.class);
                break;
            case "HyundaiElantra":
                b = new Intent(DesktopActivity.this, HyundaiElantra.class);
                break;
            case "HyuandaiTuscon":
                b = new Intent(DesktopActivity.this, HyundaiTucson.class);
                break;
            default:
                b = new Intent(DesktopActivity.this, ToyotaCorolla.class);
                break;
            //             {"", "Chevrolet", "Ford", "Honda", "Hyundai", "Toyota"};
//            odelChev = {"Model", "Impala", "Silverado"};
//            Ford = {"Model", "Explorer", "FSeries"};
//            Honda = {"Model", "Accord", "Civic"};
//            Hyundai = {"Model", "Elantra", "Tuscan"};
//            Toyato = {"Model", "Camry", "Corolla"};


        }
            //                b.putExtra("miles", mileage);
            b.putExtras(bund);
            startActivity(b);
    }

    private TextWatcher Watcher = new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,int after) {
//                DesktopActivity.this.changeText.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

                         mileage = Integer.parseInt(s.toString());
//                DesktopActivity.this.changeText.setText(s.toString());
            }
        };
    private TextWatcher yearWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,int after) {
//                DesktopActivity.this.changeText.setText(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

            year = Integer.parseInt(s.toString());
//                DesktopActivity.this.changeText.setText(s.toString());
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop);//this needs to go before your variables

//        carType = (EditText)findViewById(R.id.carType);
//
//        changeText = findViewById(R.id.textView);

        makeSpinner = findViewById(R.id.makeSpinner);

        modelSpinner = findViewById(R.id.modelSpinner);

        odometer = findViewById(R.id.fakeSpinner);

        yearCheck = findViewById(R.id.enterYear);

        submitButton = findViewById(R.id.submitButton);

        secretButton = findViewById(R.id.secretestButton);

        odometer.addTextChangedListener(Watcher);
//        carType.addTextChangedListener(Watcher);

//        ArrayAdapter<String> makeAdapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, );

        ArrayAdapter<String> makeAdapt = new ArrayAdapter<>(this, R.layout.drop_down_item, make);
        ArrayAdapter<String> modelAdapt = new ArrayAdapter<>(this, R.layout.drop_down_item, modelEmpty);
        ArrayAdapter<String> yearAdapt = new ArrayAdapter<>(this, R.layout.drop_down_item, yearChoic);
        modelAdapt.setDropDownViewResource(R.layout.drop_down_item);
        makeAdapt.setDropDownViewResource(R.layout.drop_down_item);

        modelSpinner.setAdapter(modelAdapt);
        makeSpinner.setAdapter(makeAdapt);
        yearCheck.setAdapter(yearAdapt);


        makeSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                DesktopActivity.this.finish();
//                DesktopActivity.this.changeText.setText(String.valueOf(position));
                if (position > 0) {
//                    Intent b = new Intent(DesktopActivity.this, ToyotaCamry.class);
//                    startActivity(b);
                    carMake = make[position];
                    ArrayAdapter<String> modelAdapt;
                    switch (position) {
                        case 1:
                            modelAdapt = new ArrayAdapter<>(DesktopActivity.this, R.layout.drop_down_item, modelChev);
                            break;
                        case 2:
                            modelAdapt = new ArrayAdapter<>(DesktopActivity.this, R.layout.drop_down_item, modelFord);
                            break;
                        case 3:
                            modelAdapt = new ArrayAdapter<>(DesktopActivity.this, R.layout.drop_down_item, modelHonda);
                            break;
                        case 4:
                            modelAdapt = new ArrayAdapter<>(DesktopActivity.this, R.layout.drop_down_item, modelHyundai);
                            break;
                        case 5:
                            modelAdapt = new ArrayAdapter<>(DesktopActivity.this, R.layout.drop_down_item, modelToyato);
                            break;
                        default:
                            modelAdapt = new ArrayAdapter<>(DesktopActivity.this, R.layout.drop_down_item, modelToyato);
                            break;
                    }
                    modelSpinner.setAdapter(modelAdapt);
                }
//                Intent b = new Intent(DesktopActivity.this, ToyotaCamry.class);
//                startActivity(b);
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        modelSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                DesktopActivity.this.finish();
//                DesktopActivity.this.changeText.setText(String.valueOf(position));
                if (position > 0) {
                    switch (carMake) {
//                        "Chevrolet", "Ford", "Honda", "Hyundai", "Toyota"
                        case "Chevrolet":
                            carModel = modelChev[position];
                            break;
                        case "Ford":
                            carModel = modelFord[position];
                            break;
                        case "Honda":
                            carModel = modelHonda[position];
                            break;
                        case "Hyundai":
                            carModel = modelHyundai[position];
                            break;
                        case "Toyota":
                            carModel = modelToyato[position];
                            break;
                    }
                    carMake = make[position];
//                    Intent b = new Intent(DesktopActivity.this, ToyotaCamry.class);
//                    startActivity(b);
//                    ArrayAdapter<String> modelAdapt = new ArrayAdapter<>(DesktopActivity.this, R.layout.drop_down_item , model);
//                    modelSpinner.setAdapter(modelAdapt);
                }
//                Intent b = new Intent(DesktopActivity.this, ToyotaCamry.class);
//                startActivity(b);
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        modelSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (yearChoic[position] != "") {
                    year = Integer.parseInt(yearChoic[position]);
                }
            } // to close the onItemSelected

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                if (mileage != 0) {
                    if (year > 2018 && year < 2024) {
                        intentCaller(carMake + carModel);
                    }
                }
            }
        });
        secretButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DesktopActivity.this, AmericaPop.class);
                startActivity(i);
                DesktopActivity.this.finish();

            }

        });
    }
}