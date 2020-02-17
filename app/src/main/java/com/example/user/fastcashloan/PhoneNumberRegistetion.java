package com.example.user.fastcashloan;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberRegistetion extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText phoneNumber;
    private Button next_btn;
    private  ImageView imageView;
    AlertDialog.Builder builder;
    private ProgressBar loading;
    String URL_REGIST="http://192.168.0.105/users/newregiste.php";
    String Phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_registetion);

        TextView already_login_text=findViewById(R.id.go_to_Login);

         phoneNumber = (EditText) findViewById(R.id.set_password_et);
         imageView=findViewById(R.id.back_btn_number_regi);
        mAuth = FirebaseAuth.getInstance();
         next_btn=(Button) findViewById(R.id.nextID);

         next_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(TextUtils.isEmpty(phoneNumber.getText().toString()))
                 {
                     phoneNumber.setError("phone number is empty..");
                     phoneNumber.findFocus();
                     return;
                 }
                 else if(phoneNumber.length()<11)
                 {
                     phoneNumber.setError("digit is need.. ");
                     phoneNumber.findFocus();
                     return;
                 }
                 else
                 {
                     InsertData();
                 }


             }
         });

        already_login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =new Intent(PhoneNumberRegistetion.this,LoginPage.class) ;
               startActivity(intent);
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

    private void InsertData() {
        Phonenumber=phoneNumber.getText().toString().trim();
        final RequestQueue requestQueue= Volley.newRequestQueue(this);
        Intent intent=new Intent(PhoneNumberRegistetion.this,PinPackCode.class);
        intent.putExtra("Phonenumber",Phonenumber);
        startActivity(intent);
        phoneNumber.setText("");

        // StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_REGIST,
             //   new Response.Listener<String>() {
           //         @Override
               //     public void onResponse(String response)
                 //   {
                   //     Toast.makeText(PhoneNumberRegistetion.this,response, Toast.LENGTH_SHORT).show();
                     //

    //}
      //          }, new Response.ErrorListener() {
        //    @Override
          //  public void onErrorResponse(VolleyError error)
            //{
              //  Toast.makeText(PhoneNumberRegistetion.this, "try again..", Toast.LENGTH_SHORT).show();

     //       }
       // }


        //){
          //  @Override
            //protected Map<String, String> getParams()  {
              //  Map<String,String> params= new HashMap<String,String>();
//
  //                  params.put("phoneNumber",Phonenumber);
//
  //              return params;
    //        }
      //  };

//requestQueue.add(stringRequest);











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
