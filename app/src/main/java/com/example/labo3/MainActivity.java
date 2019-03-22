package com.example.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import static com.example.labo3.AppConstant.TEXT_KEY;

public class MainActivity extends AppCompatActivity {

    //inicializamos nuestras variables
    private EditText mEdit;
    private Button mButton, mButtonShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdit = findViewById(R.id.et_text);
        mButton = findViewById(R.id.btn_send);
        mButtonShare = findViewById(R.id.btn_share);

        //Creamos el listener
        mButton.setOnClickListener(v -> {
            String text = mEdit.getText().toString();
            //Creamos un intent, este es el explícito
            Intent mIntent = new Intent(MainActivity.this, NewActivity.class);
            //Le pasamos por el identificador text un string. ¿Qué es le keyValue?
            mIntent.putExtra(TEXT_KEY, text);
            startActivity(mIntent);

        });

        mButtonShare.setOnClickListener(v -> {
            String text = mEdit.getText().toString();
            Intent mIntent = new Intent();
            //Esto lo setteamos para decirle a la aplicación qué tipo de datos va a recibir y está lista...
            mIntent.setType("text/plain");
            //Setteamos un tipo de acción
            mIntent.setAction(Intent.ACTION_SEND);
            //Acá hay una llave que ya la co
            mIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(mIntent);
        });
    }
}
