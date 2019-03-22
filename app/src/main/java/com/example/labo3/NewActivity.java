package com.example.labo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.labo3.AppConstant.TEXT_KEY;

public class NewActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //buscamos el mensaje por id
        mTextView = findViewById(R.id.n_text);
        //Instanciamos un intent, esto va a servir para agarrar el intent que viene de la otra activity
        Intent mIntent = getIntent();
        if (mIntent!=null){
            mTextView.setText(mIntent.getStringExtra(Intent.EXTRA_TEXT)); //Esta debe ser la misma llave
        }
    }
}
