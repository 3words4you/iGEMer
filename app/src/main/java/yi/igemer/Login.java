package yi.igemer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

    }

    public void loginClick(View v){
        EditText etEmail = (EditText) findViewById(R.id.etEmail);
        String email = etEmail.getText().toString();
        EditText etPassword = (EditText) findViewById(R.id.etPassword);
        String password = etPassword.getText().toString();
        if(isValid(email,password)){
            DatabaseHelper db = new DatabaseHelper(this);
            if(db.loginIsSuccess(email,password)){
                Toast.makeText(this,"Login Successfully",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this,"Login failed, please enter correct account",Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void goToRegister(View v){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
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
