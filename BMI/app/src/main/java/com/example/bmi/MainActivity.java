package com.example.bmi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 設置活動的佈局

        // 通過 ID 獲取界面元件實例
        final EditText edtHeight = findViewById(R.id.edtHeight); // 身高輸入框
        final EditText edtWeight = findViewById(R.id.edtWeight); // 體重輸入框
        Button btnCalc = findViewById(R.id.btnCalc); // 計算按鈕
        Button btnClear = findViewById(R.id.btnClear); // 清除按鈕
        final TextView txvShow = findViewById(R.id.txvShow); // 顯示結果的文本視圖

        // 設置計算按鈕的點擊事件監聽器
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightStr = edtHeight.getText().toString(); // 獲取輸入的身高字符串
                String weightStr = edtWeight.getText().toString(); // 獲取輸入的體重字符串

                // 檢查身高和體重字符串是否為空
                if (!"".equals(heightStr) && !"".equals(weightStr)) {
                    float height = Float.parseFloat(heightStr) / 100; // 將身高轉換為米（m）
                    float weight = Float.parseFloat(weightStr); // 將體重字符串轉換為浮點數

                    float bmi = weight / (height * height); // 計算 BMI

                    // 使用 String.format() 來格式化 BMI 值，保留兩位小數
                    String resultText = "BMI: " + String.format("%.2f", bmi);
                    txvShow.setText(resultText); // 將計算結果顯示在文本視圖上

                    // 根據 BMI 值設置文字顏色
                    if (bmi < 18.5) {
                        txvShow.setTextColor(Color.BLUE); // BMI < 18.5 設置為藍色（過瘦）
                    } else if (bmi > 24.9) {
                        txvShow.setTextColor(Color.RED); // BMI > 24.9 設置為紅色（超重）
                    } else {
                        txvShow.setTextColor(Color.GREEN); // BMI 在範圍內設置為綠色（正常）
                    }
                }
            }
        });

        // 設置清除按鈕的點擊事件監聽器
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHeight.setText(""); // 清空身高輸入框
                edtWeight.setText(""); // 清空體重輸入框
                txvShow.setText(""); // 清空結果顯示文本
                txvShow.setTextColor(Color.BLACK); // 將結果顯示文本顏色重置為預設黑色
            }
        });
    }
}
