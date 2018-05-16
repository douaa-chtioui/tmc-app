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
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.Checkup;
import tmc.ensi.org.tmcapp.model.Comment;

public class DoctorCheckupReply extends AppCompatActivity {
    private TextView question;
    private Button sendbtn;
    private long identifier;
    EditText doctorCommentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_checkup_reply);
        String quest = getIntent().getStringExtra("question");
        identifier = Objects.requireNonNull(getIntent().getExtras()).getLong("identifier");
        question = findViewById(R.id.tv_patientComment);
        question.setText(quest);
        doctorCommentText = findViewById(R.id.et_doctorReply);
        sendbtn = findViewById(R.id.btn_send);
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new UpdateCheckupAsyncTask(DoctorCheckupReply.this).execute(identifier, doctorCommentText.getText().toString());
            }
        });

    }

    public void onUpdateCheckupSuccess() {
        Intent intent = new Intent(getApplicationContext(), DoctorCheckupActivity.class);
        startActivity(intent);
        finish();
    }

    public void onUpdateCheckupFailure() {
        Toast.makeText(getBaseContext(), "Failed", Toast.LENGTH_LONG).show();
        sendbtn.setEnabled(true);
    }

    private static class UpdateCheckupAsyncTask extends AsyncTask<Object, Void, Void> {
        private ProgressDialog progress;
        private boolean success = false;
        private DoctorCheckupReply activity;

        UpdateCheckupAsyncTask(DoctorCheckupReply activity) {
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
        protected Void doInBackground(Object... params) {
            try {
                success = ApplicationModel.get().updateCheckup((long) params[0], new Comment((String) params[1]));
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
                this.activity.onUpdateCheckupSuccess();
            } else {
                this.activity.onUpdateCheckupFailure();
            }
        }

    }
}
