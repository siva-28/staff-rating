package com.example.abinash.student.juniors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class page2 extends AppCompatActivity {

    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkit();
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("details",0);

        TextView text =(TextView) findViewById(R.id.user);
        String dislay=preferences.getString("username",null);

        text.setText(dislay);
        logout=(Button)findViewById(R.id.log_out2);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                check.save(page2.this,"Student","true");
                check.sharesave(getApplicationContext(),"");
                Intent out=new Intent(getApplicationContext(),Logged.class);
                startActivity(out);
                finish();
            }
        });
    }
    public void checkit()
    {

        Boolean check=Boolean.valueOf(com.example.abinash.student.juniors.check.readset(page2.this,"Student","true"));

        Intent intro=new Intent(page2.this,Logged.class);
        intro.putExtra("Student",check);
        if(check)
        {
            startActivity(intro);
        }

    }

}