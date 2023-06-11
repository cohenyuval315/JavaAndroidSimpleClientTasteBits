package com.example.tastebits.shared.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tastebits.data.DataManagerSingleton;
import com.example.tastebits.R;
import com.example.tastebits.driver.activities.DriverMainActivity;
import com.example.tastebits.data.enums.UserType;
import com.example.tastebits.shared.dialogs.AlertDialogFragment;
import com.example.tastebits.data.models.UserModel;
import com.example.tastebits.restaurant.activities.RestaurantMainActivity;
import com.example.tastebits.shift_supervisor.activities.ShiftSupervisorMainActivity;
import com.example.tastebits.customer.activities.UserMainActivity;

public class LoginActivity extends AppCompatActivity {

    AlertDialog alertDialog;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void register(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }

    public void openDialog(String tag,String title,String message){
        DialogFragment d = new AlertDialogFragment(title,message,new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        d.show(getSupportFragmentManager(), tag);
    }

    public void login(View view){
        EditText emailInputEditText = findViewById(R.id.login_email_input);
        EditText passwordInputEditText =  findViewById(R.id.login_password_input);
        String email = String.valueOf(emailInputEditText.getText());
        String password = String.valueOf(passwordInputEditText.getText());
        DataManagerSingleton dm = DataManagerSingleton.getInstance();
        boolean exists = dm.isUserExists(email);
        if (!exists){
            openDialog("Tag","invalid email","email does not exists");
            return;
        }
        UserModel user = dm.login(email,password);
        if (user == null){
            openDialog("Tag","wrong password","wrong password");
            return;
        }
        UserType type = user.getUserType();
        switch (type) {
            case DRIVER:
                startActivity(new Intent(LoginActivity.this, DriverMainActivity.class));
                break;
            case RESTAURANT:
                startActivity(new Intent(LoginActivity.this, RestaurantMainActivity.class));
                break;
            case SHIFT_SUPERVISOR:
                startActivity(new Intent(LoginActivity.this, ShiftSupervisorMainActivity.class));
                break;
            case USER:
                startActivity(new Intent(LoginActivity.this, UserMainActivity.class));
                break;
            default:
                break;
        }
    }
    public void forgotPassword(View view) {
        EditText emailInputEditText = findViewById(R.id.login_email_input);
        String email = String.valueOf(emailInputEditText.getText());
        if (email.length() == 0){
            email = "please enter email in the email address";
        }
        openDialog("forgot password","sending email to",email);
        sendForgetPasswordEmail(email);
    }
    public void sendForgetPasswordEmail(String email){
        // Impl
    }
}