package com.example.onroadassistant.sign_in;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.onroadassistant.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    EditText firstname,lastname,email,phone,username,password,confirmpassword;
    Button sub_button,ret_button;
    String fname,lname,mail,number,usrname,pswrd,cnfrmpswrd;
    String s1;
    DatabaseReference mDatabase;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        FirebaseApp.initializeApp(signup.this);

        firebaseAuth = FirebaseAuth.getInstance();




        firstname=(EditText) findViewById(R.id.first_name);
        lastname=(EditText) findViewById(R.id.last_name);
        email=(EditText) findViewById(R.id.email);
        phone=(EditText) findViewById(R.id.contact);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.et_for_password);
        confirmpassword=(EditText) findViewById(R.id.et_confirm);

        ret_button=(Button) findViewById(R.id.retrieve_button);
        sub_button=(Button) findViewById(R.id.submit_button);


        sub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname=firstname.getText().toString();
                lname=lastname.getText().toString();
                mail=email.getText().toString();
                number=phone.getText().toString();
                usrname=username.getText().toString();
                pswrd=password.getText().toString();
                cnfrmpswrd=confirmpassword.getText().toString();

                Data data=new Data(fname,lname,mail,number,usrname,pswrd,cnfrmpswrd);


                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child("User_Data").child("User_1").push().setValue(data);

                firebaseAuth.createUserWithEmailAndPassword(mail,pswrd).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                            Toast.makeText(signup.this, "User Created", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(signup.this, "not created", Toast.LENGTH_SHORT).show();



                    }
                });
            }
        });


    }
}

class Data{
    String firstname;
    String lastname;
    String email;
    String phone;
    String username;
    String password;
    String confirmpassword;

    Data()
    {

    }

    Data(String firstname,String lastname,String email,String phone,String username,String password,String confirmpassword)
    {

        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.phone=phone;
        this.username=username;
        this.password=password;
        this.confirmpassword=confirmpassword;

    }

}

