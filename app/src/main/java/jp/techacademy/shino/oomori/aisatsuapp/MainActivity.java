package jp.techacademy.shino.oomori.aisatsuapp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView dateTextView;
    TextView aisatsuTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        dateTextView = (TextView) findViewById(R.id.textView1);
        aisatsuTextView = (TextView) findViewById(R.id.textView2);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            dateTextView.setText("");
            aisatsuTextView.setText("");
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int p_hourOfDay, int p_minute) {
                        Log.d("UI-PARTS", String.valueOf(p_hourOfDay) + ":" + String.valueOf(p_minute));
                        dateTextView.setText(String.valueOf(p_hourOfDay) + ":" + String.valueOf(p_minute));
                        if((p_hourOfDay *100 + p_minute >= 200) && (p_hourOfDay *100 + p_minute < 1000)) {
                            aisatsuTextView.setText("「おはよう」");
                        }else if((p_hourOfDay *100 + p_minute >= 1000) && (p_hourOfDay *100 + p_minute < 1800)) {
                            aisatsuTextView.setText("「こんにちは」");
                        } else if((p_hourOfDay *100 + p_minute >= 1800) || ((p_hourOfDay *100 + p_minute >= 0) && (p_hourOfDay *100 + p_minute < 200))) {
                            aisatsuTextView.setText("「こんばんは」");
                        } else {
                            aisatsuTextView.setText("Hi!");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }
}
