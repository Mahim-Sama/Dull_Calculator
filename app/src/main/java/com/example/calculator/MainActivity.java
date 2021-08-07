package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.textView);
        e1.setShowSoftInputOnFocus(false);

        e1.setOnClickListener(v -> {
            if (getText(R.string.Display).equals(e1.getText().toString())) {
                e1.setText("");
            }
        });
    }

    public void updateData(String strAdd){
        String s1 = e1.getText().toString();
        int pos = e1.getSelectionStart();
        String ls = s1.substring(0, pos);
        String rs = s1.substring(pos);
        if(getString(R.string.Display).equals(e1.getText().toString())){
            e1.setText(strAdd);
            e1.setSelection(pos + 1);
        }
        else{
            e1.setText(String.format("%s%s%s", ls, strAdd, rs));
            e1.setSelection(pos + 1);
        }

    }

    public void ZeroBtn(View view){
        updateData("0");
    }

    public void OneBtn(View view){
        updateData("1");
    }

    public void TwoBtn(View view){
        updateData("2");
    }

    public void ThreeBtn(View view){
        updateData("3");
    }

    public void FourBtn(View view){
        updateData("4");
    }

    public void FiveBtn(View view){
        updateData("5");
    }

    public void SixBtn(View view){
        updateData("6");
    }

    public void SevenBtn(View view){
        updateData("7");
    }

    public void EightBtn(View view){
        updateData("8");
    }

    public void NineBtn(View view){
        updateData("9");
    }

    public void RightBracketBtn(View view){
        updateData("(");
    }

    public void leftBracketBtn(View view){
        updateData(")");
    }

    public void PercentageBtn(View view){
        updateData("%");
    }

    public void DivisionBtn(View view){
        updateData("÷");
    }

    public void MultiplicationBtn(View view){
        updateData("×");
    }

    public void PlusBtn(View view){
        updateData("+");
    }

    public void MinusBtn(View view){
        updateData("-");
    }

    public void PointBtn(View view){
        updateData(".");
    }

    public void EqualsBtn(View view){
        String s2 = e1.getText().toString();

        s2 = s2.replaceAll("×", "*");
        s2 = s2.replaceAll("÷", "/");

        Expression exp1 = new Expression(s2);
        String sol = String.valueOf(exp1.calculate());

        e1.setText(sol);
        e1.setSelection(sol.length());
    }

    public void ClearBtn(View view){
        e1.setText("");
    }
}