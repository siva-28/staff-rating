package com.example.abinash.student.juniors;

        import android.content.Intent;

        import android.net.Uri;
        import android.os.Bundle;
        import android.support.design.widget.TabLayout;
        import android.support.v4.view.PagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;


public class MainActivity extends AppCompatActivity implements tab1.OnFragmentInteractionListener,tab2.OnFragmentInteractionListener {

    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkit();
        logout=(Button)findViewById(R.id.log_out2);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                check.save(MainActivity.this,"Student","true");
                check.sharesave(getApplicationContext(),"");
                Intent out=new Intent(getApplicationContext(),Logged.class);
                startActivity(out);
                finish();
            }
        });
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tablay);
        tabLayout.addTab(tabLayout.newTab().setText("Department"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager=(ViewPager) findViewById(R.id.pager);
        final adapters ada=new adapters(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(ada);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    public void checkit()
    {

        Boolean check=Boolean.valueOf(com.example.abinash.student.juniors.check.readset(MainActivity.this,"Student","true"));

        Intent intro=new Intent(MainActivity.this,Logged.class);
        intro.putExtra("Student",check);
        if(check)
        {
            startActivity(intro);
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri)
    {

    }
}