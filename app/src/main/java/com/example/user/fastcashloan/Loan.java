package com.example.user.fastcashloan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;

public class Loan extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:
                    if (mAuth.getCurrentUser()!=null)
                    {
                        startActivity(new Intent(getApplicationContext(),Auth.class));
                        overridePendingTransition(0, 0);
                    }
                    else {

                        Intent intent =new Intent(Loan.this,LoginPage.class);
                        startActivity(intent);
                    }

                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(getApplicationContext(),Account.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        }
    };
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
        mAuth=FirebaseAuth.getInstance();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);

        Button button=findViewById(R.id.button_regi_log);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regi_log_btn=new Intent(Loan.this,PhoneNumberRegistetion.class);
                startActivity(regi_log_btn);
            }
        });
    }
}
