package com.example.yossi.firebaselessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tvDisplay;
    FirebaseAuth firebaseAuth;
    Button btnSignOut;
    String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        firebaseAuth = FirebaseAuth.getInstance();

        tvDisplay = findViewById(R.id.tvDisplay);
        btnSignOut = findViewById(R.id.btnSignOut);
        btnSignOut.setOnClickListener(this);

        str = firebaseAuth.getCurrentUser().getEmail();
        tvDisplay.setText(str);


    }

    @Override
    public void onClick(View view) {

        firebaseAuth.signOut();
        tvDisplay.setText("");

    }
}
