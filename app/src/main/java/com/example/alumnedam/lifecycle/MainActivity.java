package com.example.alumnedam.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("hora", this.hora);
    }

    private String hora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificar("on Create");


        if(savedInstanceState == null ){
            Calendar dataActual = Calendar.getInstance();
            int hour = dataActual.get(Calendar.HOUR_OF_DAY);
            int minute = dataActual.get(Calendar.SECOND);
            int segon = dataActual.get(Calendar.MINUTE);


            hora = "Hora:" + hour + ":" + minute + ":" + segon;

        }

        else {

            this.hora = savedInstanceState.getString("hora");


        }
        TextView tvHora = (TextView) findViewById(R.id.tvHora);
        tvHora.setText(hora);
    }

    @Override
    protected void onStop() {
        super.onStop();
        notificar("on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notificar("on Destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        notificar("onStart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        notificar("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notificar("onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        notificar("onRestart");
    }


    public void notificar (String mensaje){

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        Log.i ("tag", mensaje);
    }
}
