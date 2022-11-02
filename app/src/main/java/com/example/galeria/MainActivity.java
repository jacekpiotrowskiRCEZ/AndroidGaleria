package com.example.galeria;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 private Button buttonP,buttonN;
 private ImageView imgsw;
 private int[] images={R.drawable.kot1,R.drawable.kot2,R.drawable.kot3,R.drawable.kot4};
 private int position=0;
 private Switch switch1;
 private ConstraintLayout back;
 private EditText ktory_obraz;
 private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonN=(Button) findViewById(R.id.buttonN);
        buttonP=(Button) findViewById(R.id.buttonP);
        imgsw=(ImageView) findViewById(R.id.imgsw);
        switch1=(Switch) findViewById(R.id.switch1);
        back= (ConstraintLayout) findViewById(R.id.back);
        ktory_obraz=(EditText) findViewById(R.id.ktory_obraz);
        textView2=(TextView) findViewById(R.id.textView3);



buttonP.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (position>0) position--;
        else if (position<=0) position=images.length-1;
        imgsw.setImageResource(images[position]);
    }
});
buttonN.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if(position<images.length-1) position++;
        else if (position>= images.length-1) position=0;
        imgsw.setImageResource(images[position]);
    }
});
switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if (switch1.isChecked()) {

           back.setBackgroundColor(Color.parseColor("#0000dd"));


        } else {
            // The toggle is disabled
            back.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }
});

ktory_obraz.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //textView2.setText(ktory_obraz.getText());
        int nr = 0;
        try {
            nr = Integer.valueOf(String.valueOf(ktory_obraz.getText()));
        } catch ( NumberFormatException nfe){ imgsw.setImageResource(images[0]);}
        if (nr> images.length-1) {
            imgsw.setImageResource(images[0]);
        }
        switch (nr){
            case 0:imgsw.setImageResource(images[nr]);break;
            case 1:imgsw.setImageResource(images[nr]);break;
            case 2:imgsw.setImageResource(images[nr]);break;
            case 3:imgsw.setImageResource(images[nr]);break;
           //default:imgsw.setImageResource(images[0]);

        }


    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
});

    }
}