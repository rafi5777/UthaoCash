package com.example.user.fastcashloan;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class Photos_Upload extends AppCompatActivity {
    RelativeLayout front_of_nid,employee,Proof_bill;
    RelativeLayout back_of_nid,Handheld,TIN_certificat;
    Dialog front_dialog,back_of_nid_dialog,employee_ID_Dialog,Handheld_NID_dialog,Proof_bills_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos__upload);
        front_dialog=new Dialog(this);
        back_of_nid_dialog=new Dialog(this);
        employee_ID_Dialog=new Dialog(this);
        Handheld_NID_dialog=new Dialog(this);
        Proof_bills_dialog=new Dialog(this);

        front_of_nid=findViewById(R.id.Front_photo);
        back_of_nid=findViewById(R.id.Backphoto);
        employee=findViewById(R.id.EmployeeID);
        Handheld=findViewById(R.id.Handheld_NID);
        Proof_bill=findViewById(R.id.Proof_bills);
        TIN_certificat=findViewById(R.id.TIN_cer);

        TIN_certificat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Photos_Upload.this,CameraForTin_ID.class);
                startActivity(intent);
            }
        });
    }
    public void ShowPopup1(View v) {

        Button btnFollow;
        front_dialog.setContentView(R.layout.pop_up_for_front_nid);


        btnFollow = (Button) front_dialog.findViewById(R.id.photoUpload);
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Photos_Upload.this,CameraForFront_NID.class);
                startActivity(intent);
            }
        });
        front_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        front_dialog.show();

    }
    public void ShowPopup2(View v) {

        Button btnFollow;
        back_of_nid_dialog.setContentView(R.layout.pop_up_for_front_nid);


        btnFollow = (Button) back_of_nid_dialog.findViewById(R.id.photoUpload);
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Photos_Upload.this,CameraForBack_NID.class);
                startActivity(intent);
            }
        });
        back_of_nid_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        back_of_nid_dialog.show();

    }
    public void ShowPopup4(View v) {

        Button btnFollow;
        employee_ID_Dialog.setContentView(R.layout.employee_id);


        btnFollow = (Button) employee_ID_Dialog.findViewById(R.id.photoUpload);
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Photos_Upload.this,CameraForEmployee_NID.class);
                startActivity(intent);
            }
        });
        employee_ID_Dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        employee_ID_Dialog.show();

    }
    public void ShowPopup3(View v) {

        Button btnFollow;
        Handheld_NID_dialog.setContentView(R.layout.handheld_nid);


        btnFollow = (Button) Handheld_NID_dialog.findViewById(R.id.photoUpload);
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Photos_Upload.this,CameraForEmployee_NID.class);
                startActivity(intent);
            }
        });
        Handheld_NID_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Handheld_NID_dialog.show();

    }
    public void ShowPopup5(View v) {

        Button btnFollow;
        Proof_bills_dialog.setContentView(R.layout.billing_prove);


        btnFollow = (Button) Proof_bills_dialog.findViewById(R.id.photoUpload);
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Photos_Upload.this,CameraForEmployee_NID.class);
                startActivity(intent);
            }
        });
        Proof_bills_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Proof_bills_dialog.show();

    }
}



