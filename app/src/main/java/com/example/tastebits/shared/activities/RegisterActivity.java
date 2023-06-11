package com.example.tastebits.shared.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.shared.dialogs.AlertDialogFragment;
import com.example.tastebits.data.models.UserModel;
import com.example.tastebits.customer.activities.UserMainActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void login(View view) {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }

    public void mainActivity(View view) {
        startActivity(new Intent(RegisterActivity.this, UserMainActivity.class)); // main
    }
    public void Register(View view){
        EditText nameInputEditText = findViewById(R.id.register_full_name_input);
        EditText emailInputEditText = findViewById(R.id.register_email_input);
        EditText passwordInputEditText = findViewById(R.id.register_password_input);
        String fullName = String.valueOf(nameInputEditText.getText());
        String email = String.valueOf(emailInputEditText.getText());
        String password = String.valueOf(passwordInputEditText.getText());
        DataManagerSingleton dm = DataManagerSingleton.getInstance();

        boolean exists = dm.isUserExists(email);
        if (exists){
            DialogFragment d = new AlertDialogFragment("credential error","user already exists");
            d.show(getSupportFragmentManager(), "register_error");
            return;
        }
        if (email.length() == 0){
            DialogFragment d = new AlertDialogFragment("input error","please enter email");
            d.show(getSupportFragmentManager(), "register_error");
            return;
        }
        UserModel user = dm.register(email,password);
        if (user == null){
            DialogFragment d = new AlertDialogFragment("internal error","error");
            d.show(getSupportFragmentManager(), "register_error");
            return;
        }
        DialogFragment d = new AlertDialogFragment("Successful register","please log in ",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                startActivity(new Intent(RegisterActivity.this, UserMainActivity.class));
            }
        });
        d.show(getSupportFragmentManager(), "register");

    }


}