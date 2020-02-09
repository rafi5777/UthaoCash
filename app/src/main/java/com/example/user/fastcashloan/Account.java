package com.example.user.fastcashloan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

public class Account extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String[] componenet_name;
    private int[] component_image={R.drawable.repayment,R.drawable.loan_record,R.drawable.money,
            R.drawable.email,R.drawable.share,R.drawable.customer_service,R.drawable.feedback,R.drawable.letter,R.drawable.settings};

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(getApplicationContext(),Loan.class));
                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_dashboard:
                    if (mAuth.getCurrentUser()!=null)
                    {
                        startActivity(new Intent(getApplicationContext(),Auth.class));
                    }
                    else {

                        Intent intent =new Intent(Account.this,LoginPage.class);
                        startActivity(intent);
                    }

                    overridePendingTransition(0, 0);
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        mAuth=FirebaseAuth.getInstance();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_notifications);

        ListView listView=findViewById(R.id.list);
        componenet_name=getResources().getStringArray(R.array.component_name);

        CustomAdapter adapter=new CustomAdapter(this,componenet_name,component_image);
        listView.setAdapter((ListAdapter) adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    if(mAuth.getCurrentUser()!=null)
                        {
                            Intent intent =new Intent(Account.this,Repayment.class);
                            startActivity(intent);
                        }
                        else
                    {
                        Intent intent =new Intent(Account.this,LoginPage.class);
                        startActivity(intent);
                    }


                }
                if(i==1)
                {if(mAuth.getCurrentUser()!=null)
                {
                    Intent intent =new Intent(Account.this,Loan_Record.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent =new Intent(Account.this,LoginPage.class);
                    startActivity(intent);
                }
                }
                if(i==2)
                {
                    if(mAuth.getCurrentUser()!=null)
                    {
                        Intent intent =new Intent(Account.this,Coupon.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent =new Intent(Account.this,LoginPage.class);
                        startActivity(intent);
                    }
                }
                if(i==3)
                {
                    if(mAuth.getCurrentUser()!=null)
                    {
                        Intent intent =new Intent(Account.this,Messages.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent =new Intent(Account.this,LoginPage.class);
                        startActivity(intent);
                    }
                }
                if(i==4)
                {

                        Intent intent =new Intent(Account.this,Share.class);
                        startActivity(intent);

                }
                if(i==5)
                {
                    Intent intent =new Intent(Account.this,Online_Services.class);
                    startActivity(intent);
                }
                if(i==6)
                {
                    Intent intent =new Intent(Account.this,Feedback.class);
                    startActivity(intent);
                }
                if(i==7)
                {
                    Intent intent =new Intent(Account.this,About.class);
                    startActivity(intent);
                }
                if(i==8)
                {
                    if(mAuth.getCurrentUser()!=null)
                    {
                        Intent intent =new Intent(Account.this,Setting_Activity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intent =new Intent(Account.this,LoginPage.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
