package com.tony.dayone_database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText Ename, Ecounty, Ephone, Eage, Eemail, Epass, Econfrimpass;
    private Button Bregister, Bview;
    private DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ename = findViewById(R.id.edt_name);
        Ecounty = findViewById(R.id.edt_County);
        Ephone = findViewById(R.id.edt_phone);
        Eage = findViewById(R.id.edt_age);
        Eemail = findViewById(R.id.edt_email);
        Epass = findViewById(R.id.edt_password);
        Econfrimpass = findViewById(R.id.edt_confirmpass);
        Bregister = findViewById(R.id.btn_register);
        Bview = findViewById(R.id.btnView);

        mRef = FirebaseDatabase.getInstance().getReference().child("Users");

        Bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TryRegister();
            }
        });
        Bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RetrieveActivity.class));
            }
        });


    }

    private void TryRegister() {

        String name = Ename.getText().toString().trim();
        String county = Ecounty.getText().toString().trim();
        String phone = Ephone.getText().toString().trim();
        String age = Eage.getText().toString().trim();
        String email = Eemail.getText().toString().trim();
        String pass = Epass.getText().toString().trim();
        String confirmpass = Econfrimpass.getText().toString().trim();
        
        if (name.isEmpty() || name.length()< 5){
            showError(Ename, "Name must be 5 characters and above");
        }
        else if (county.isEmpty()){
            showError(Ecounty, "County must not be empty");
        }
        else if (phone.isEmpty()){
            showError(Ephone, "Phone must not be empty");
        }
        else if (age.isEmpty()){
            showError(Eage, "Age must not be empty");
        }
        else if (email.isEmpty() || !email.endsWith("@gmail.com")){
            showError(Eemail, "Email not valid");
        }
        else if (pass.isEmpty() || pass.length()< 5){
            showError(Epass, "Password must be 5 characters and above");
        }
        else if (confirmpass.isEmpty() || !confirmpass.equals(pass)){
            showError(Econfrimpass, "Password does not match");
        }else {
            Users user = new Users(name, county,phone, age, email, pass, confirmpass);
            mRef.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Ename.setText("");
                        Ecounty.setText("");
                        Ephone.setText("");
                        Eage.setText("");
                        Eemail.setText("");
                        Epass.setText("");
                        Econfrimpass.setText("");
                        Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Registration Unsuccessful...Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void showError(EditText field, String text) {
        field.setError(text);
        field.requestFocus();
    }
}