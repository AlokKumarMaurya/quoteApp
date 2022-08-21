package com.example.quoteapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    int i=0;
    public TextView textView;
    public  TextView name;
    public Button button;
    private FloatingActionButton floatingActionButton;
    private String[] quote={"You can’t go back and change the beginning, but you can start where you are and change the ending",

            "Convince yourself that you have the power to be all what you wish to be. It is YOU who could generate in you a huge power of motivation to push you forward and ignite you to think and to do.",

            "You can’t go back and change the beginning, but you can start where you are and change the ending.",

            "Happiness is not the absence of problems, it’s the ability to deal with them.",

            "The most precious gift we can offer others is our presence. When our mindfulness embraces those we love, they will bloom like flowers."};




    private  String[] author={"alok","avinash","anil","sunil","papa"};


    private  Long aa=6386506352L;
    private  String number="tel:" + aa;
    int REQUEST_CALL=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.editTextTextPersonName);
        button=findViewById(R.id.button);
        textView.setText(quote[0]);
        name=findViewById(R.id.textView);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        name.setText(author[0]);




        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent callintent =new Intent(Intent.ACTION_CALL);
//                callintent.setData(Uri.parse("tel:"+638650635));
//                startActivity(callintent);

               // ActivityCompat.requestPermissions( String[] {Manifest.permission.CALL_PHONE});

               // startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(number)));


//                ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
//
//                MainActivity.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);


                if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CALL_PHONE} , REQUEST_CALL);
                }
                else
                {
                    startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(number)));
                }





//                if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
//                {
//                    ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.INTERNET} , REQUEST_CALL);
//                }
//                else
//                {String a="byjus.com";
//                    Uri webpage=Uri.parse(a);
//                    //startActivity(new Intent(Intent.ACTION_VIEW,webpage));
//                    Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
//                    //intent.setData(Uri.parse(a));
//
//                    if(intent.resolveActivity(getPackageManager())!= null)
//                    {
//                        startActivity(intent);
//                    }
//
//
//                }






//                Uri data=Uri.parse(number);
//                Intent intent=new Intent(Intent.ACTION_CALL);
//                intent.setData(Uri.parse(number));
//                if(intent.resolveActivity(getPackageManager()) !=null){startActivity(intent);}

                Toast.makeText(getApplicationContext(),"pressed the floating action button",Toast.LENGTH_LONG).show();
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(quote[i]);
                name.setText(author[i]);
                i++;
                if(i>=quote.length)
                {
                    i=0;
                }
            }
        });
    }
}