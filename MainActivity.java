package com.mahamaya.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    EditText customerName, goldWeight, goldRate;
    TextView result;
    Button calcButton;
    ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customerName = findViewById(R.id.customerName);
        goldWeight = findViewById(R.id.goldWeight);
        goldRate = findViewById(R.id.goldRate);
        result = findViewById(R.id.result);
        calcButton = findViewById(R.id.calcButton);
        logoImage = findViewById(R.id.logoImage);

        calcButton.setOnClickListener(v -> {
            try {
                String wStr = goldWeight.getText().toString().trim();
                String rStr = goldRate.getText().toString().trim();
                if(wStr.isEmpty() || rStr.isEmpty()) {
                    result.setText("Please enter weight and rate");
                    return;
                }
                double weight = Double.parseDouble(wStr);
                double rate = Double.parseDouble(rStr);
                double total = weight * rate;
                result.setText("Total: ₹ " + String.format("%.2f", total));
            } catch (Exception e) {
                result.setText("Please enter valid numbers!");
            }
        });

        logoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // simple interaction: clear fields when logo tapped (optional)
                customerName.setText(""); goldWeight.setText(""); goldRate.setText(""); result.setText("Total: ");
            }
        });
    }
}
