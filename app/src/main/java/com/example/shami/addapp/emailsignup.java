package com.example.shami.addapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class emailsignup extends AppCompatActivity {


     Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailsignup);

        btnlogin=(Button)findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(emailsignup.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
