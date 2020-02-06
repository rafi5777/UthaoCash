package com.example.user.fastcashloan;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PinPackCode extends AppCompatActivity {
    private FirebaseAuth mAuth;
    PinView pinView;
    private String verificationId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_pack_code);
        mAuth=FirebaseAuth.getInstance();
        pinView=findViewById(R.id.pinView);
        TextView textView=findViewById(R.id.text33);
        textView.setText(getIntent().getStringExtra("number"));
        String number=getIntent().getStringExtra("number");
        sendverificationCode(number);
    }
    private void sendverificationCode(String number) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+88" + number, 60, TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD
                , mCallBack
        );


    }
    private  void setVerifyCode(String code)
    {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId,code);
        singInWithCredential(credential);
    }

    private void singInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this ,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(PinPackCode.this,SetPassword.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        } else {
                            Toast.makeText(PinPackCode.this, "Something happen..", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId=s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if(code!=null){
                pinView.setText(code);
                setVerifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            if ( e instanceof FirebaseAuthUserCollisionException)
            {
                Toast.makeText(getApplicationContext(), "This number is already use", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(PinPackCode.this,LoginPage.class);
                startActivity(intent);
            }
            else {
            Toast.makeText(PinPackCode.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }}

    };


    }

