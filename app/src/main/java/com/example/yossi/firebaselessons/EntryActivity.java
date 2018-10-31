package com.example.yossi.firebaselessons;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EntryActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnSignIn,btnGotoLoginDialog;
    Dialog d;
    EditText etEmail,etPass;
    Button btnLogIn;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnGotoLoginDialog = findViewById(R.id.btnGotoLoginDialog);

        btnSignIn.setOnClickListener(this);
        btnGotoLoginDialog.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void logInSuccesful() {

        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {


        if(view == btnSignIn) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if(view == btnGotoLoginDialog)
        {
            d = new Dialog(this);
            d.setContentView(R.layout.login_dialog);
            d.setCancelable(true);
            etEmail = d.findViewById(R.id.etEmail);
            etPass = d.findViewById(R.id.etPass);
            btnLogIn = d.findViewById(R.id.btnLogIn);
            btnLogIn.setOnClickListener(this);
            d.show();
        }
        else if(view == btnLogIn)
        {
            if(!etEmail.getText().toString().equals("") && !etPass.getText().toString().equals(""))
                    login();
            else
                Toast.makeText(this, "חסר שם משתמש או סיסמא", Toast.LENGTH_SHORT).show();
        }

    }

    private void login() {

        firebaseAuth.signInWithEmailAndPassword(etEmail.getText().toString(),etPass.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {

                    logInSuccesful();

                }

            }


        });


    }
}
