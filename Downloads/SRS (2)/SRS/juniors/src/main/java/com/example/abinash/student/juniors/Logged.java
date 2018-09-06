package com.example.abinash.student.juniors;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Logged extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dis_play);
        final EditText name=(EditText) findViewById(R.id.user);
        final EditText pass=(EditText) findViewById(R.id.password);
        final Button login = (Button) findViewById(R.id.log_in);
        final Button sign = (Button) findViewById(R.id.sign_up);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String use=name.getText().toString();
                String pas=name.getText().toString();
                check.save(Logged.this,"Student","false");
                check.sharesave(getApplicationContext(),use);
                Intent dis=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(dis);
                finish();
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regis=new Intent(Logged.this,Register.class);
                startActivity(regis);

            }
        });

    }

}
