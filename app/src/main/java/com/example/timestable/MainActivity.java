package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ListView myListView;

    public void generateTimesTable(int timesTableNumber){
        final ArrayList<Integer> timesTable = new ArrayList<Integer>();

        for(int j=1;j<=10;j++){
            timesTable.add(j*timesTableNumber);
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,timesTable);

        myListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = (ListView) findViewById(R.id.myListView);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        int max = 20;
        int startPoint = 10;

        seekBar.setMax(max);
        seekBar.setProgress(startPoint);

        generateTimesTable(startPoint);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("Change", Integer.toString(i));

                int min = 1;
                int timesTableNumber;
                if(i<min){
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                }else {
                    timesTableNumber = i;
                }
                generateTimesTable(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}