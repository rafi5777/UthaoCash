package com.example.user.fastcashloan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class PhoneNumberRegistetion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_registetion);
        final EditText ET_setPassWord = findViewById(R.id.set_password_et);
        ImageView imageView=findViewById(R.id.back_btn_number_regi);
        Button next_btn=findViewById(R.id.nextID);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String number=ET_setPassWord.getText().toString().trim();
                if (number.isEmpty()||number.length()<11)
                {
                    ET_setPassWord.setError("Number is required");
                    ET_setPassWord.requestFocus();
                    return;
                }

                Intent next_pin_pack=new Intent(PhoneNumberRegistetion.this,PinPackCode.class);
                next_pin_pack.putExtra("number",number);
                startActivity(next_pin_pack);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_to_loan=new Intent(PhoneNumberRegistetion.this,Loan.class);
                startActivity(back_to_loan);
            }
        });

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null)
        {
            Intent intent = new Intent( this,UserProfile.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
