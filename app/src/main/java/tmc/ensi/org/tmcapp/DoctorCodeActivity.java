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

import tmc.ensi.org.tmcapp.model.ApplicationModel;

public class DoctorCodeActivity extends AppCompatActivity {

    private EditText doctorCodeInput;
    private Button validateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_code);
        this.doctorCodeInput = findViewById(R.id.txt_inputDoctorCode);
        this.validateButton = findViewById(R.id.btn_validateDoctorCode);
        this.validateButton.setOnClickListener(new SaveOnClickListener());
    }

    private class SaveOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            validateButton.setEnabled(false);
            new AssignDoctorAsyncTask(DoctorCodeActivity.this).execute(doctorCodeInput.getText().toString());
        }

    }

    public void onAssignDoctorSuccess() {
        Intent intent = new Intent(getApplicationContext(), CheckupActivity.class);
        startActivity(intent);
        finish();
    }

    public void onAssignDoctorFailure() {
        Toast.makeText(getBaseContext(), "Failed", Toast.LENGTH_LONG).show();
        validateButton.setEnabled(true);
    }

    private static class AssignDoctorAsyncTask extends AsyncTask<String, Void, Void> {
        private ProgressDialog progress;
        private boolean success = false;
        private DoctorCodeActivity activity;

        AssignDoctorAsyncTask(DoctorCodeActivity activity) {
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
        protected Void doInBackground(String... params) {
            try {
                success = ApplicationModel.get().assignDoctor(params[0]);
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
                this.activity.onAssignDoctorSuccess();
            } else {
                this.activity.onAssignDoctorFailure();
            }
        }

    }


}
