package com.example.temptransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button_Click(View view) {
        EditText celsiusInput = (EditText) findViewById(R.id.txtCelsius);
        TextView fahrenheitOutput = (TextView) findViewById(R.id.lblFahrenheit);
        double celsius = Double.parseDouble(celsiusInput.getText().toString());
        double fahrenheit = (celsius * 9 / 5) + 32;
        fahrenheitOutput.setText("華氏溫度是: " + String.format("%.2f",fahrenheit) + "℉");
    }
}