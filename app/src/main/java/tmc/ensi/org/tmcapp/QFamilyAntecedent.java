package tmc.ensi.org.tmcapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.Gender;
import tmc.ensi.org.tmcapp.model.Profile;

import static tmc.ensi.org.tmcapp.model.Gender.FEMALE;
import static tmc.ensi.org.tmcapp.model.Gender.MALE;

public class QFamilyAntecedent extends AppCompatActivity {
    private RadioGroup familyAntecendtRadioGroup;
    private Button saveButton;
    private Button  homePageButton ,retutnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qfamily_antecedent);
        saveButton = findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new SaveOnClickListener());
        familyAntecendtRadioGroup =  findViewById(R.id.rg_familyAntecedent);
        homePageButton = findViewById(R.id.btn_home);
        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean familyAntecedent = familyAntecendtRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkFamilyAntecendt_True).getId();
                ApplicationModel.get().getCurrentUser().getProfile().setFamilyAntecedent(familyAntecedent);
                Intent intent = new Intent(getApplicationContext(),UserHomeActivity.class);
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
    private class SaveOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (!validate()) {
                onUpdateProfileFailure();
                return;
            }
            saveButton.setEnabled(false);
            new UpdateProfileAsyncTask(QFamilyAntecedent.this).execute();
        }

    }
    public void onUpdateProfileSuccess() {
        Intent intent = new Intent(getApplicationContext(), FinalProfilActivity.class);
        startActivity(intent);
        finish();
    }

    public void onUpdateProfileFailure() {
        Toast.makeText(getBaseContext(), "Failed", Toast.LENGTH_LONG).show();
        saveButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;
        // TODO
        return valid;
    }

    private static class UpdateProfileAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog progress;
        private boolean success = false;
        private QFamilyAntecedent activity;

        UpdateProfileAsyncTask(QFamilyAntecedent activity) {
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