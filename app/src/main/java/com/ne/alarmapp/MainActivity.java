package com.ne.alarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button setBtn;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBtn=(Button) findViewById(R.id.button);
        edit=(EditText) findViewById(R.id.editText);
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startAlert();
            }

            private void startAlert() {
                int i= Integer.parseInt(edit.getText().toString());
                Intent intent=new Intent(MainActivity.this, BroadcastReceiver.class);
                PendingIntent pendingIntent= PendingIntent.getBroadcast(MainActivity.this.getApplicationContext(),4254852,intent,0);
                AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent);
                Toast.makeText(MainActivity.this, "Alarm set "+i +"seconds", Toast.LENGTH_SHORT).show();
            }
        });

    }
}


/*  EditText text = findViewById(R.id.time);
        int i = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (i * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds",Toast.LENGTH_LONG).show();  */