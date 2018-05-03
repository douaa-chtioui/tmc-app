package tmc.ensi.org.tmcapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.User;
import tmc.ensi.org.tmcapp.model.UserCredential;

public class LoginActivity extends AppCompatActivity {

    private static final int REQUEST_SIGNUP = 0;
    private EditText emailText;
    private EditText passwordText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailText = findViewById(R.id.input_email);
        passwordText = findViewById(R.id.input_password);
        loginButton = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new LoginOnClickListener());
        TextView signUpLink = findViewById(R.id.link_signup);
        signUpLink.setOnClickListener(new SignUpOnClickListener());
    }

    private class LoginOnClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            login();
        }

    }

    private class SignUpOnClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            // Start the Signup activity
            Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
            startActivity(intent);
        }

    }

    public void login() {
        Log.d(LoginActivity.class.getSimpleName(), "Login");
        if (!validate()) {
            onLoginFailed();
            return;
        }
        loginButton.setEnabled(false);
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        new LoginAsyncTask(this).execute(email, password);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        Intent intent = new Intent(getApplicationContext(), UserHomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        Log.i("onDestroy", "ok");
        super.onDestroy();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
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

    private static class LoginAsyncTask extends AsyncTask<String, Void, Void> {
        private ProgressDialog progress;
        private boolean success = false;
        private LoginActivity activity;

        LoginAsyncTask(LoginActivity activity)
        {
            this.activity = activity;
            progress = new ProgressDialog(activity);
            progress.setIndeterminate(true);
            progress.setMessage("Authenticating...");
        }

        @Override
        protected void onPreExecute() {
            progress.show();
        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                User user = ApplicationModel.get().login(new UserCredential(params[0], params[1]));
                success = user != null;
            } catch (Exception e) {
                Log.e(LoginActivity.class.getSimpleName(), LoginActivity.class.getSimpleName(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (progress.isShowing()) {
                progress.dismiss();
            }
            if (success) {
                this.activity.onLoginSuccess();
            } else {
                this.activity.onLoginFailed();
            }
        }
    }
}
