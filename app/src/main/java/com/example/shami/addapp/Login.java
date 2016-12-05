package com.example.shami.addapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {


    Button btnfacebook;
    Button btnemail;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        btnfacebook=(Button)findViewById(R.id.btnFaceBook);

        btnfacebook.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view)
                {
                    Intent intent=new Intent(Login.this,facebooksignup.class);
                    startActivity(intent);
                }
               });


        btnemail=(Button)findViewById(R.id.btnEmailSigin);

        btnemail.setOnClickListener(new View.OnClickListener()
        {
           @Override
            public void onClick(View view)
            {

                Intent intent=new Intent(Login.this,emailsignup.class);
                startActivity(intent);

            }

        });


        login=(Button)findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                Intent intent=new Intent(Login.this,loginscreen.class);
                startActivity(intent);
            }

        });

    }
}
