package com.example.calculator;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView math;
    private TextView resutl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        math = findViewById(R.id.tvMath);
        resutl = findViewById(R.id.tvResult);
        Button one = findViewById(R.id.btn1);
        one.setOnClickListener(this);
        Button two = findViewById(R.id.btn2);
        two.setOnClickListener(this);
        Button three = findViewById(R.id.btn3);
        three.setOnClickListener(this);
        Button four = findViewById(R.id.btn4);
        four.setOnClickListener(this);
        Button five = findViewById(R.id.btn5);
        five.setOnClickListener(this);
        Button six = findViewById(R.id.btn6);
        six.setOnClickListener(this);
        Button seven = findViewById(R.id.btn7);
        seven.setOnClickListener(this);
        Button eight = findViewById(R.id.btn8);
        eight.setOnClickListener(this);
        Button nine = findViewById(R.id.btn9);
        nine.setOnClickListener(this);
        Button clear = findViewById(R.id.btnC);
        clear.setOnClickListener(this);
        Button open = findViewById(R.id.btnOpen);
        open.setOnClickListener(this);
        Button close = findViewById(R.id.btnClose);
        close.setOnClickListener(this);
        Button divine = findViewById(R.id.btnDiv);
        divine.setOnClickListener(this);
        Button plus = findViewById(R.id.btnPlus);
        plus.setOnClickListener(this);
        Button multiple = findViewById(R.id.btnMul);
        multiple.setOnClickListener(this);
        Button minus = findViewById(R.id.btnMin);
        minus.setOnClickListener(this);
        Button equal = findViewById(R.id.btnResult);
        equal.setOnClickListener(this);
        Button zero = findViewById(R.id.btn0);
        zero.setOnClickListener(this);
        Button point = findViewById(R.id.btnPoint);
        point.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Button button = (Button) v;
        switch (button.getText().toString()) {
            case "=":
                math.setText(resutl.getText());
                resutl.setText("");
                break;
            case "C":
                math.setText("");
                resutl.setText("");
                break;
            default:
                math.append(button.getText());
                break;
        }
        calculate();
        if (math.getText().toString().length() == 0) math.setTextSize(COMPLEX_UNIT_SP, 80);
        if (math.getText().toString().length() == 9)
            math.setTextSize(COMPLEX_UNIT_SP, 60);
        if (math.getText().toString().length() == 14) math.setTextSize(COMPLEX_UNIT_SP, 40);
    }

    public void calculate() {
        String currentMath = math.getText().toString();
        Log.d("LOG", currentMath);
        Log.d("textsize", Float.toString(math.getTextSize()));

        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            String result = scriptEngine.eval(currentMath).toString();
            resutl.setText(result);
        } catch (Exception e) {
        }
    }


}
