package com.example.user.fastcashloan;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PinPackCode extends AppCompatActivity {
    private FirebaseAuth mAuth;
    PinView pinView;
    private TextView resend;
    private ProgressBar progressBar;
    private String s,Phonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_pack_code);

        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressbar);
        resend = findViewById(R.id.code_resent);
        pinView=findViewById(R.id.pinView);
        TextView textView=findViewById(R.id.text33);

        textView.setText(getIntent().getStringExtra("Phonenumber"));
        Phonenumber=getIntent().getStringExtra("Phonenumber");
        sendVerificationCode();
        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendVerificationCode();

            }
        });
        findViewById(R.id.buttonSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code=pinView.getText().toString().trim();
                if(code.isEmpty()||code.length()<6)
                    {
                         pinView.setError("Enter code...");
                        pinView.requestFocus();
                     return;
                   }
                   else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(s, pinView.getText().toString().replace(" ",""));
                    signInWithPhoneAuthCredential(credential);
                }


            }
        });
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()) {
                            Toast.makeText(PinPackCode.this, "Phone number registetion successfull", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(PinPackCode.this, SetPassword.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        } else {
                            Toast.makeText(PinPackCode.this, "Registration not success...", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }





    private  void sendVerificationCode()
    {
        new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l) {
                resend.setText(""+l/1000);
                resend.setEnabled(false);
            }

            @Override
            public void onFinish() {
                resend.setText(" Resend");
                resend.setEnabled(true);
            }
        }.start();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+88" + Phonenumber,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks()
                {
                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            PinPackCode.this.s=s;
                    }

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        Toast.makeText(PinPackCode.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }}

