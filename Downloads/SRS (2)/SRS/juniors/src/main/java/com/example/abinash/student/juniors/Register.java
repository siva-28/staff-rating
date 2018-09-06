package com.example.abinash.student.juniors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        final EditText username = (EditText) findViewById(R.id.rusername);
        final EditText pass1 = (EditText) findViewById(R.id.rpass1);
        final EditText pass2 = (EditText) findViewById(R.id.rpass2);
        final Button Register = (Button) findViewById(R.id.register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("registered", MODE_PRIVATE);
                String user = username.getText().toString();
                String pass = pass1.getText().toString();
                String passed = pass2.getText().toString();
                check.sharesave(getApplicationContext(),user);
                if (pass.toString().equals(passed.toString()))
                {
                    Intent log = new Intent(Register.this, MainActivity.class);
                    startActivity(log);
                }
                else
                {

                    Toast.makeText(getApplicationContext(),"Confrim password is incoreect",Toast.LENGTH_SHORT).show();
                }
            }


        });
    }
}
