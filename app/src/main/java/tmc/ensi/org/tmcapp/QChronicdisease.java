package tmc.ensi.org.tmcapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import tmc.ensi.org.tmcapp.model.ApplicationModel;

public class QChronicdisease extends AppCompatActivity {
    private Button nextButton, homePageButton, retutnButton;
    private RadioGroup chronicDiseaseRadioGroup;
    private RadioButton checkChronicDiseaseButton;
    private boolean chronicDisease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qchronicdisease);
        checkChronicDiseaseButton = findViewById(R.id.btn_chronicDisease_T);
        chronicDiseaseRadioGroup = findViewById(R.id.rg_chronicDisease);
        nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronicDisease = chronicDiseaseRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_chronicDisease_T).getId();
                if (chronicDisease) {
                    Intent intent = new Intent(getApplicationContext(), ChronicDiseaseActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    new UpdateProfileAsyncTask(QChronicdisease.this).execute();
                }

            }
        });
        homePageButton = findViewById(R.id.btn_home);
        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserHomeActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        retutnButton = findViewById(R.id.btn_return);
        retutnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public void onUpdateProfileSuccess() {
        Intent intent = new Intent(getApplicationContext(), FinalProfilActivity.class);
        startActivity(intent);
        finish();
    }

    public void onUpdateProfileFailure() {
        Toast.makeText(getBaseContext(), "Failed", Toast.LENGTH_LONG).show();
        nextButton.setEnabled(true);
    }

    private static class UpdateProfileAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog progress;
        private boolean success = false;
        private QChronicdisease activity;

        UpdateProfileAsyncTask(QChronicdisease activity) {
            this.activity = activity;
            progress = new ProgressDialog(activity);
            progress.setIndeterminate(true);
            progress.setMessage("Enregistrement de données...");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                success = ApplicationModel.get().updateCurrentUserProfile();
            } catch (Exception e) {
                Log.e(QFamilyAntecedent.class.getSimpleName(), QFamilyAntecedent.class.getSimpleName(), e);
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
                this.activity.onUpdateProfileSuccess();
            } else {
                this.activity.onUpdateProfileFailure();
            }
        }

    }

}