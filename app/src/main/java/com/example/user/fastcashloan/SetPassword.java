package com.example.user.fastcashloan;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.Map;

public class SetPassword extends AppCompatActivity {
    private FirebaseAuth mAuth;
  private   EditText editTextPassword;
    String URL_REGIST="http://192.168.0.105/users/newpassword.php";
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        mAuth = FirebaseAuth.getInstance();
         editTextPassword=findViewById(R.id.set_password_of_user);

        final Button button_set_pass=findViewById(R.id.btn_set_pass);



        button_set_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = editTextPassword.getText().toString().trim();
                if (password.isEmpty()||password.length() < 6) {
                    editTextPassword.setError("Enter your password please");
                    editTextPassword.requestFocus();
                    return;
                }
                else
                {
                    InsertData();
                }

            }
        });
    }
    private void InsertData() {

        password=editTextPassword.getText().toString().trim();
        final RequestQueue requestQueue= Volley.newRequestQueue(this);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_REGIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(SetPassword.this,response, Toast.LENGTH_SHORT).show();
                        editTextPassword.setText("");

                        Intent go_to_profile=new Intent(SetPassword.this,UserProfile.class);
                        startActivity(go_to_profile);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(SetPassword.this, "try again..", Toast.LENGTH_SHORT).show();

            }
        }


        ){
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String> params= new HashMap<String,String>();

                params.put("password",password);

                return params;
            }
        };

        requestQueue.add(stringRequest);











    }
}
