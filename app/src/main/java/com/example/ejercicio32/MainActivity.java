package com.example.ejercicio32;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] saludos,pulsar;
    Random aleatorio = new Random();
    String uri = "https://www.educastur.es";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = findViewById(R.id.button);
        TextView texto = findViewById(R.id.textView);
        MediaPlayer media = MediaPlayer.create(this,R.raw.tortuga);
        saludos = getResources().getStringArray(R.array.saludos);
        pulsar = getResources().getStringArray(R.array.boton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hola mundo",Toast.LENGTH_LONG).show();
                media.start();
                int boton_saludo = aleatorio.nextInt(saludos.length);
                boton.setText(saludos[boton_saludo]);
                texto.setText(pulsar[boton_saludo]);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.uno:
                Toast.makeText(this,"Primera Opcion",Toast.LENGTH_LONG).show();
                break;
            case R.id.dos:
                Toast.makeText(this,"Segunda Opcion",Toast.LENGTH_LONG).show();
                break;
            case R.id.tres:
                Toast.makeText(this,"Tercera Opcion",Toast.LENGTH_LONG).show();
                break;
            case R.id.cuatro:
                Toast.makeText(this,"Cuarta Opcion",Toast.LENGTH_LONG).show();
                Uri educastur = Uri.parse(uri);
                Intent educastur_ver = new Intent(Intent.ACTION_VIEW,educastur);
                startActivity(educastur_ver);
                break;
            case R.id.cinco:
                Toast.makeText(this,"Quinta Opcion",Toast.LENGTH_LONG).show();
                break;
            case R.id.seis:
                Toast.makeText(this,"Sexta Opcion",Toast.LENGTH_LONG).show();
                break;
            case R.id.siete:
                Toast.makeText(this,"Sptima Opcion",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}