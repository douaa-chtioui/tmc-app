package tmc.ensi.org.tmcapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.ChronicDisease;
import tmc.ensi.org.tmcapp.model.Disease;

public class CoronaryPathologyActivity extends AppCompatActivity {
    RadioGroup stentsPosRGroup ;
    RadioGroup aeroCoronaryRGroup ;
    Button nextButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coronary_pathology);
        stentsPosRGroup = (RadioGroup) findViewById(R.id.rg_stentsPos) ;
        aeroCoronaryRGroup = (RadioGroup) findViewById(R.id.rg_aeroCoronary) ;


        nextButton = findViewById(R.id.btn_save);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean stentsPos = stentsPosRGroup.getCheckedRadioButtonId() == findViewById(R.id.rb_checkStentsPos).getId();
                boolean aeroCoronary = aeroCoronaryRGroup.getCheckedRadioButtonId() == findViewById(R.id.rb_checkAeroCoronary).getId();
                ChronicDisease chronicDisease = new ChronicDisease();
                chronicDisease.setDisease(Disease.CoronaryPathology);
                chronicDisease.setStentsPose(stentsPos);
                chronicDisease.setAortoCoronaryBypass(aeroCoronary);
                ApplicationModel.get().getCurrentUser().setChronicDisease(chronicDisease);
                new UpdateChronicDiseaseAsyncTask(CoronaryPathologyActivity.this).execute();
            }
        });


    }

    public void onUpdateProfileSuccess() {
        Intent intent = new Intent(getApplicationContext(),FinalProfilActivity.class);
        startActivity(intent);
        finish();
    }

    public void onUpdateProfileFailure() {
        Toast.makeText(getBaseContext(), "Failed", Toast.LENGTH_LONG).show();
        nextButton.setEnabled(true);
    }

    private static class UpdateChronicDiseaseAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProgressDialog progress;
        private boolean success = false;
        private CoronaryPathologyActivity activity;

        UpdateChronicDiseaseAsyncTask(CoronaryPathologyActivity activity) {
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
                success = ApplicationModel.get().updateCurrentChronicDisease();
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
