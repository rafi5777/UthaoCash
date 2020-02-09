package com.example.user.fastcashloan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ModifyPassWord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_pass_word);
        setContentView(R.layout.activity_modify_pass_word);
        ImageView back_btn=findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_back=new Intent(ModifyPassWord.this,Setting_Activity.class);
                startActivity(intent_back);
            }
        });
        final RelativeLayout old_pass=findViewById(R.id.layout_old_pass);
        final RelativeLayout new_pass=findViewById(R.id.layout_new_pass);
        Button submite=findViewById(R.id.submite_btn);
        Button submite_new_pass=findViewById(R.id.submite_new_pass);

        final EditText old_pass_edit_text=findViewById(R.id.old_pass_edit);
        EditText new_pass_text=findViewById(R.id.new_pass);
        EditText new_pass_text1=findViewById(R.id.new_pass1);
    }
}
