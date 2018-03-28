package tmc.ensi.org.tmcapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.User;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = "SignupActivity";

    private EditText firstnameText;
    private EditText lastnameText;
    private EditText emailText;
    private EditText passwordText;
    private Button signupButton;
    private TextView loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailText = (EditText) findViewById(R.id.input_email);
        passwordText = (EditText) findViewById(R.id.input_password);
        firstnameText = (EditText) findViewById(R.id.input_firstname);
        lastnameText = (EditText) findViewById(R.id.input_lastname);
        loginLink = (TextView) findViewById(R.id.link_login);
        signupButton = (Button) findViewById(R.id.btn_signup);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");
        if (!validate()) {
            onSignupFailed();
            return;
        }
        signupButton.setEnabled(false);
        String firstname = firstnameText.getText().toString();
        String lastname = lastnameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        User user = new User(email, password, firstname, lastname, 42);
        new CreateUserAsyncTask().execute(user);
    }

    public void onSignupSuccess() {
        signupButton.setEnabled(true);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;
        String name = lastnameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        if (name.isEmpty() || name.length() < 3) {
            lastnameText.setError("at least 3 characters");
            valid = false;
        } else {
            lastnameText.setError(null);
        }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }
        return valid;
    }

    private class CreateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private ProgressDialog progress;
        private boolean success = false;

        public CreateUserAsyncTask() {
            progress = new ProgressDialog(SignupActivity.this);
            progress.setIndeterminate(true);
            progress.setMessage("Creating Account...");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.show();
        }

        @Override
        protected Void doInBackground(User[] params) {
            try {
                success = ApplicationModel.get().createUser(params[0]);
            } catch (Exception e) {
                Log.e(SignupActivity.class.getSimpleName(), SignupActivity.class.getSimpleName(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (progress.isShowing()) {
                progress.dismiss();
            }
            if (success) {
                onSignupSuccess();
            } else {
                onSignupFailed();
            }
        }
    }

}
