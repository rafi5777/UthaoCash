package com.example.user.fastcashloan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfile extends AppCompatActivity {
private ImageView back_btn;
private EditText first_name,last_name,email,nid,address;
private Spinner gender,religion;
private TextView dateOfbirth;
private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        back_btn=findViewById(R.id.back_btn);

        first_name=findViewById(R.id.username);
        last_name=findViewById(R.id.LastName);
        email=findViewById(R.id.email);
        dateOfbirth=findViewById(R.id.datePicker);
        gender=findViewById(R.id.GenderSpinner);
        religion=findViewById(R.id.ReligionSpinner);
        nid=findViewById(R.id.NID);
        address=findViewById(R.id.DetailsAddress);

        submit=findViewById(R.id.submite);


        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_auth=new Intent(UserProfile.this,Auth.class);
                startActivity(intent_auth);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String F_name = first_name.getText().toString().trim();
                String L_name = last_name.getText().toString().trim();
                String Email = email.getText().toString().trim();
                String Date_birht = dateOfbirth.getText().toString().trim();
                String Gernder = gender.getSelectedItem().toString().trim();
                String Religion = religion.getSelectedItem().toString().trim();
                String NID = nid.getText().toString().trim();
                String Address = address.getText().toString().trim();
                if (F_name.isEmpty()) {
                    first_name.setError("Enter your password please");
                    first_name.requestFocus();
                    return;
                }

              else  if (L_name.isEmpty()) {
                    last_name.setError("Enter your Last name please");
                    last_name.requestFocus();
                    return;
                }
              else  if (Email.isEmpty()) {
                    email.setError("Enter your emailplease");
                    email.requestFocus();
                    return;
                }
              else  if (Date_birht.isEmpty()) {
                    dateOfbirth.setError("Enter yourDate of birth please");
                    dateOfbirth.requestFocus();
                    return;
                }
              else  if (Gernder.isEmpty()) {
                    Toast.makeText(UserProfile.this, "please select your gender", Toast.LENGTH_SHORT).show();
                }
             else   if (NID.isEmpty()) {
                    nid.setError("Enter your NID please");
                    nid.requestFocus();
                    return;
                }
            else    if ( Address.isEmpty()) {
                    address.setError("Enter your Address please");
                    address.requestFocus();
                    return;
                }
                else  if (Religion.isEmpty()) {
                    Toast.makeText(UserProfile.this, "please select your religion", Toast.LENGTH_SHORT).show();
                }

                else
                {

                }
            }
        });

    }
}
