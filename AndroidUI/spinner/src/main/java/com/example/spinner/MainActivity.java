package com.example.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner)this.findViewById(R.id.spinnerid);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String number = null;
        String[] numberArray =
                getResources().getStringArray(R.array.number_array);
        number = numberArray[position];

        TextView selectNumber = (TextView)this.findViewById(R.id.selectnumber);
        selectNumber.setText(number);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
