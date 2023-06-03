package com.jar.nerdi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginPage extends AppCompatActivity {

    EditText loginUsername, loginPassword;
    Button loginButton;
    TextView signupRedirectText;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //needs to be fix
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
        //needs to be fix

        TextView textView = findViewById(R.id.signupRedirectedText);
        CharSequence originalText = textView.getText();

        int startIndex = originalText.length() / 1;
        StyleSpan boldStyleSpan = new StyleSpan(Typeface.BOLD);

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(originalText);
        spannableStringBuilder.setSpan(boldStyleSpan, 20, startIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableStringBuilder);

        TextView textView2 = findViewById(R.id.signupRedirectedText);
        String originalText2 = textView.getText().toString();

        int startIndex2 = originalText2.length() / 1;

        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(originalText);

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#6E42A6"));
        spannableStringBuilder.setSpan(colorSpan, 20, startIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(spannableStringBuilder);

        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        signupRedirectText = findViewById(R.id.signupRedirectedText);
        loginButton = findViewById(R.id.login_button);
        DB = new DBHelper(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = loginUsername.getText().toString();
                String pass = loginPassword.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginPage.this, "Please enter all the fields", Toast.LENGTH_LONG).show();
                } else {
                    Boolean checkuserpass = DB.checkUsernamePassword(user, pass);
                    if (checkuserpass){
                        Toast.makeText(LoginPage.this, "Welcome to NERDI", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), WelcomeScreen.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginPage.this, "Invalid credentials", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupPage.class);
                startActivity(intent);
            }
        });
    }
}