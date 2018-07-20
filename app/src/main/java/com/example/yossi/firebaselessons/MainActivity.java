package com.example.yossi.firebaselessons;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText etEmail,etPass;
    Button btnSign;

    String mail,pass;

    FirebaseAuth firebaseAuth;
    //TextView tvDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tvDisplay = findViewById(R.id.tvDisplay);

        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnSign=findViewById(R.id.btnSign);

        btnSign.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();








    }


    public void singingIn() {
        Intent in = new Intent(this,Main2Activity.class);
        startActivity(in);
        /*String s = firebaseAuth.getCurrentUser().getEmail();
        tvDisplay.setText(s);*/


    }

    @Override
    public void onClick(View view) {

        mail = etEmail.getText().toString();
        pass = etPass.getText().toString();

        if(!mail.equals("") && !pass.equals(""))
        {

            firebaseAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful())
                    {
                        singingIn();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this,"NOT OK",Toast.LENGTH_LONG).show();

                    }

                }


            });

        }

    }
}
