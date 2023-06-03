package com.jar.nerdi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupPage extends AppCompatActivity {

    EditText signupUsername, signupPassword, signupRepassword;
    TextView loginRedirectText;
    Button signupButton;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);

        TextView textView = findViewById(R.id.loginRedirectedText);
        CharSequence originalText = textView.getText();

        int startIndex = originalText.length() /1;
        StyleSpan boldStyleSpan = new StyleSpan(Typeface.BOLD);

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(originalText);
        spannableStringBuilder.setSpan(boldStyleSpan, 17, startIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableStringBuilder);

        TextView textView2 = findViewById(R.id.loginRedirectedText);
        String originalText2 = textView.getText().toString();

        int startIndex2 = originalText2.length() / 1;

        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(originalText);

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#6E42A6"));
        spannableStringBuilder.setSpan(colorSpan, 16, startIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableStringBuilder);

        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupRepassword = findViewById(R.id.signup_repassword);
        signupButton = findViewById(R.id.signup_button);
        loginRedirectText = findViewById(R.id.loginRedirectedText);
        DB = new DBHelper(this);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = signupUsername.getText().toString();
                String pass = signupPassword.getText().toString();
                String repass = signupRepassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")){
                    Toast.makeText(SignupPage.this, "Please enter all the fields", Toast.LENGTH_LONG).show();
                } else {
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkUsername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert == true){
                                Toast.makeText(SignupPage.this, "Registered successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent (getApplicationContext(), LoginPage.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignupPage.this, "Registration failed", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(SignupPage.this, "User already exists! Kindly sign in", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(SignupPage.this, "Passwords do not match.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(intent);
            }
        });

    }
}