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

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.ChronicDisease;
import tmc.ensi.org.tmcapp.model.Profile;

import static tmc.ensi.org.tmcapp.model.Disease.ValvePathology;

public class ValvePathologyActivity extends AppCompatActivity {
    private Button saveButton;
    private RadioButton checkMecanicalValve , checkNonMecanicalValve , checkBiologicalValve , checkNonBiologicalValve ;
    private RadioGroup mecanicalValveRadioGroup,biologicalValveRadioGroup ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valve_pathology);
        mecanicalValveRadioGroup = findViewById(R.id.rg_mecanicalValve);
        biologicalValveRadioGroup = findViewById(R.id.rg_biologicalValve);
        checkBiologicalValve = findViewById(R.id.btn_checkBiologicalValve);
        checkNonBiologicalValve = findViewById(R.id.btn_checkNoBiologicalValve);
        checkMecanicalValve= findViewById(R.id.btn_checkMecanicalValve);
        checkNonMecanicalValve = findViewById(R.id.btn_checkNoMecanicalValve);
        saveButton = findViewById(R.id.btn_valvePathology);
      //  saveButton.setOnClickListener(new SaveOnClickListener());
    }

    @Override
    protected void onStart() {
        super.onStart();
        //initForm();
    }
    /*private void initForm() {
        ChronicDisease  chronicDisease= ApplicationModel.get().getCurrentUser().getChronicDisease();
        if (chronicDisease != null) {
            if (chronicDisease.isMechanicalValve()) {
                checkMecanicalValve.setChecked(true);
            } else {
                checkNonMecanicalValve.setChecked(true);
            }
        }
        if (chronicDisease != null) {
            if (chronicDisease.isBiologicalValve()) {
                checkBiologicalValve.setChecked(true);
            } else {
                checkNonBiologicalValve.setChecked(true);
            }
        }
    }
    private class SaveOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            saveButton.setEnabled(false);
            boolean mecanicalValve = mecanicalValveRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkNoMecanicalValve).getId();
          boolean biologicalValve = biologicalValveRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkBiologicalValve).getId();
            ChronicDisease chronicDisease = new ChronicDisease.Builder().newChronicDisease()
                    .withDisease(ValvePathology)
                    .withmechanicalValve(mecanicalValve)
                    .withBiologicalValve(biologicalValve)
                    .build();
            new UpdateChronicDiseaseAsyncTask(ValvePathologyActivity.this).execute(chronicDisease);
        }

    }
    public void onUpdateChronicDiseaseSuccess() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }
    private static class UpdateChronicDiseaseAsyncTask extends AsyncTask<ChronicDisease, Void, Void> {
        private ProgressDialog progress;
        private boolean success = false;
        private ValvePathologyActivity activity;

        UpdateChronicDiseaseAsyncTask(ValvePathologyActivity activity) {
            this.activity = activity;
            progress = new ProgressDialog(activity);
            progress.setIndeterminate(true);
            progress.setMessage("enregistrement de donnés...");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.show();
        }

        @Override
        protected Void doInBackground(ChronicDisease... params) {
            try {
             //   success = ApplicationModel.get().updateCurrentUserChronicDisease(params[0]);
            } catch (Exception e) {
                Log.e(ValvePathologyActivity.class.getSimpleName(), ValvePathologyActivity.class.getSimpleName(), e);
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
               // this.activity.onUpdateChronicDiseaseSuccess();
            }
        }

    } */

}
