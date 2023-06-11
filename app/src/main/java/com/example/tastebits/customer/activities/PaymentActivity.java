package com.example.tastebits.customer.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tastebits.R;


public class PaymentActivity extends AppCompatActivity {

    private EditText cardNumberEditText;
    private EditText cardHolderEditText;
    private EditText expiryDateEditText;
    private EditText cvvEditText;
    private Button payButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cardNumberEditText = findViewById(R.id.cardNumberEditText);
        cardHolderEditText = findViewById(R.id.cardHolderEditText);
        expiryDateEditText = findViewById(R.id.expiryDateEditText);
        cvvEditText = findViewById(R.id.cvvEditText);
        payButton = findViewById(R.id.payButton);
        cancelButton = findViewById(R.id.cancelButton);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProceedDialog();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaymentActivity.this, RestaurantMenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
    private void openProceedDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("are you sure?");
        builder.setPositiveButton("proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(PaymentActivity.this, "Request Successful Waiting for Restaurant Confirm", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PaymentActivity.this, UserMainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }
}
