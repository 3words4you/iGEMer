package yi.igemer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void backToLogin(View v){
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }

    public void registerClick(View v){
        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        String email = etEmail.getText().toString();
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        String password = etPassword.getText().toString();

        //check input is valid,true:go to main page
        if(isValid(email,password)){
            DatabaseHelper db = new DatabaseHelper(this);
            if(db.addUserData(email,password)){
                Toast.makeText(this,"Register Successfully",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
            }
            else {
                Toast.makeText(this, "Email is existed, Please login", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, Login.class);
                startActivity(i);
            }
        }
    }

    public Boolean isValid(String email,String password){

        if(email.trim().equals("")){
            Toast.makeText(this,"Email address is required",Toast.LENGTH_SHORT).show();
            return false;
        }

        if(password.trim().equals("")){
            Toast.makeText(this,"Password is required",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
