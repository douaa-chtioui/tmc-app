package tmc.ensi.org.tmcapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.Checkup;

public class CheckupForm extends AppCompatActivity {
    private Button saveButton;
    EditText patientCommentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkup_form);
        patientCommentText = findViewById(R.id.editName);
        saveButton = findViewById(R.id.btnSend);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checkup checkup = new Checkup();
                checkup.setCheckupDate(new Date());
                checkup.setPatientComment(patientCommentText.getText().toString());
                new CreateCheckupAsyncTask(CheckupForm.this).execute(checkup);
            }
        });

    }

    public void onCreateCheckupSuccess() {
        Intent intent = new Intent(getApplicationContext(), CheckupActivity.class);
        startActivity(intent);
        finish();
    }

    public void onCreateCheckupFailure() {
        Toast.makeText(getBaseContext(), "Failed", Toast.LENGTH_LONG).show();
        saveButton.setEnabled(true);
    }

    private static class CreateCheckupAsyncTask extends AsyncTask<Checkup, Void, Void> {
        private ProgressDialog progress;
        private boolean success = false;
        private CheckupForm activity;

        CreateCheckupAsyncTask(CheckupForm activity) {
            this.activity = activity;
            progress = new ProgressDialog(activity);
            progress.setIndeterminate(true);
            progress.setMessage("Saving Data...");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.show();
        }

        @Override
        protected Void doInBackground(Checkup... params) {
            try {
                success = ApplicationModel.get().createCheckup(params[0]);
            } catch (Exception e) {
                Log.e(ProfileActivity.class.getSimpleName(), ProfileActivity.class.getSimpleName(), e);
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
                this.activity.onCreateCheckupSuccess();
            } else {
                this.activity.onCreateCheckupFailure();
            }
        }

    }
}
