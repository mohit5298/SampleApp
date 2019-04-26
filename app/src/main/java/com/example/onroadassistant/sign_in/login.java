package com.example.onroadassistant.sign_in;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onroadassistant.R;
import com.example.onroadassistant.UserLogin.MapsActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class login extends AppCompatActivity {

    EditText username, password;
    Button login_btn, signup_btn;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // firebaseAuth=FirebaseAuth.getInstance();

        username = (EditText) findViewById(R.id.user_name_et);
        password = (EditText) findViewById(R.id.password_et);
        login_btn = (Button) findViewById(R.id.login_btn);
        signup_btn = (Button) findViewById(R.id.signup_btn);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String upass = password.getText().toString();

//                firebaseAuth.signInWithEmailAndPassword(uname,upass).addOnCompleteListener(login.this,new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                        if (task.isSuccessful()){
//                            firebaseAuth.getCurrentUser();
//                            Toast.makeText(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                        }
//                        else{
//
//                            Toast.makeText(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

            }
        });

        final login activityObject = login.this;

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//            Intent intent2=new Intent(login.this,User_dialog.class);
//            startActivity(intent2);
                 activityObject.showDialog();



//                RadioGroup rg = (RadioGroup) findViewById (R.id.radio_grp);
//                Button b1=(Button) findViewById(R.id.proceed_button);
//
//                int idOfSelected = rg.getCheckedRadioButtonId();
//
//                switch(idOfSelected) {
//                    case R.id.user:
//                        b1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Intent i1=new Intent(login.this,signup.class);
//                                startActivity(i1);
//                            }
//                        });
//
//                        break;
//
//                    case R.id.provider:
//
//                        b1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Intent i2=new Intent(login.this,mechSignUp.class);
//                                startActivity(i2);
//                            }
//                        });
//
//                        break;
//                }

            }
        });


    }

    public void showDialog() {
        Dialog dialog = new Dialog(login.this);
        dialog.setContentView(R.layout.choseuser_daialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();

        ImageButton imageButton1=(ImageButton)findViewById(R.id.user_imgbtn);
        ImageButton imageButton2=(ImageButton) findViewById(R.id.mech_imgbtn);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(login.this,signup.class);
                startActivity(intent1);
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(login.this,mechSignUp.class);
                startActivity(intent2);
            }
        });


}

}
