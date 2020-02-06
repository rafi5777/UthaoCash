package com.example.user.fastcashloan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Auth extends AppCompatActivity {

    private String[] immeadiately_Loan;
    private int[] loanItemPicture={R.drawable.school_id,R.drawable.workinfo,R.drawable.mobile,
            R.drawable.disinfo,R.drawable.stack_of_photos};
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

                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(getApplicationContext(),Account.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_dashboard);

        ListView listView=findViewById(R.id.immeadiatelyLoan_list);
        immeadiately_Loan=getResources().getStringArray(R.array.immeadiatelyLoan);

        CustomAdapter adapter=new CustomAdapter(this,immeadiately_Loan,loanItemPicture);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0)
                {
                    Intent intent =new Intent(Auth.this,UserProfile.class);
                    startActivity(intent);

                }
                else if(i==1)
                {
                    Intent intent =new Intent(Auth.this,WorkType.class);
                    startActivity(intent);

                }
                else if(i==2)
                {
                    Intent intent =new Intent(Auth.this,Contacts.class);
                    startActivity(intent);

                }
                else  if(i==3)
                {
                    Intent intent =new Intent(Auth.this,Disbursement.class);
                    startActivity(intent);

                }
                else  if(i==4)
                {
                    Intent intent =new Intent(Auth.this,Photos_Upload.class);
                    startActivity(intent);
                }
            }
        });


    }
}