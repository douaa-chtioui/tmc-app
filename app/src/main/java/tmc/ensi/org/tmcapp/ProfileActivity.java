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
import tmc.ensi.org.tmcapp.model.User;

import static tmc.ensi.org.tmcapp.model.Gender.MALE;

public class ProfileActivity extends AppCompatActivity {
    private RadioGroup genderRadioGroup, smokerRadioGroup, marriedRadioGroup, diabeticRadioGroup, rmenopause, hypertensionRadioGroup, dyslipidemieRadioGroup, personalAntecedentRadioGroup, familyAntecendtRadioGroup;
    private TextView tmenopause;
    private Button saveButton;
    private RadioButton checkFemaleButton, checkMaleButton, checkSmockerButton, checkNotSmockerButton , checkMarriedButton ,checkNotMarriedButton ,checkDiabiticButton ,checkNotDiabiticButton, checkMenopauseButton,checkNoMenopauseButton  ,checkHypertensionButton ,checkNoHypertensionButton ,checkDyslipidemieButton ,checkNoDyslipidemieButton , checkFamilyAntecedentButton ,checkNoFamilyAntecedentButton , checkPersonalAntecedentButton , checkNoPersonalAntecedentButton ;
    private NumberPicker heightPicker;
    private NumberPicker weightPicker;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        heightPicker = findViewById(R.id.np_height);
        heightPicker.setMinValue(140);
        heightPicker.setValue(160);
        heightPicker.setMaxValue(220);
        weightPicker = findViewById(R.id.np_weight);
        weightPicker.setMinValue(30);
        weightPicker.setValue(60);
        weightPicker.setMaxValue(160);
        tmenopause = findViewById(R.id.t_menopause);
        tmenopause.setEnabled(false);
        genderRadioGroup = findViewById(R.id.rg_gender);
        checkFemaleButton = findViewById(R.id.btn_checkFemale);
        checkMaleButton = findViewById(R.id.btn_checkMale);
        checkMenopauseButton = findViewById(R.id.btn_checkMenopause_T);
        checkMenopauseButton.setEnabled(false);
        checkNoMenopauseButton = findViewById(R.id.btn_checkMenopause_F);
        checkNoMenopauseButton.setEnabled(false);
        checkMarriedButton = findViewById(R.id.btn_checkMarried_T);
        checkNotMarriedButton = findViewById(R.id.btn_checkMarried_F);
        checkDiabiticButton = findViewById(R.id.btn_checkDiabetic_T);
        checkNotDiabiticButton = findViewById(R.id.btn_checkDiabetic_F);

        checkHypertensionButton = findViewById(R.id.btn_checkhypertension_T);
        checkNoHypertensionButton = findViewById(R.id.btn_checkhypertension_F);
        checkDyslipidemieButton = findViewById(R.id.btn_checkdyslipidemie_T);
        checkNoDyslipidemieButton = findViewById(R.id.btn_checkDyslipidemie_F);
        checkFamilyAntecedentButton = findViewById(R.id.btn_checkFamilyAntecendt_True);
        checkNoFamilyAntecedentButton  = findViewById(R.id.btn_checkFamilyAntecendt_False);
        checkPersonalAntecedentButton  = findViewById(R.id.btn_checkPersonalAntecedent_T);
        checkNoPersonalAntecedentButton = findViewById(R.id.btn_checkPersonalAntecedent_F);
        checkSmockerButton = findViewById(R.id.btn_checkSmoker_T);
        checkNotSmockerButton = findViewById(R.id.btn_checkSmoker_F);
        rmenopause = findViewById(R.id.rg_menopause);
        smokerRadioGroup = findViewById(R.id.rg_smoker);
        marriedRadioGroup = findViewById(R.id.rg_married);
        diabeticRadioGroup = findViewById(R.id.rg_diabetic);
        hypertensionRadioGroup = findViewById(R.id.rg_hypertension);
        dyslipidemieRadioGroup = findViewById(R.id.rg_dyslipidemie);
        familyAntecendtRadioGroup = findViewById(R.id.rg_familyAntecedent);
        personalAntecedentRadioGroup = findViewById(R.id.rg_personalAntecedent);
        saveButton = findViewById(R.id.btn_save);
        saveButton.setOnClickListener(new SaveOnClickListener());
        genderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = genderRadioGroup.getCheckedRadioButtonId();
                View radioButton = genderRadioGroup.findViewById(id);
                if (radioButton.getId() == R.id.btn_checkFemale) {
                    checkMenopauseButton.setEnabled(true);
                    checkNoMenopauseButton.setEnabled(true);
                    tmenopause.setEnabled(true);
                } else {
                    checkMenopauseButton.setEnabled(false);
                    checkNoMenopauseButton.setEnabled(false);
                    tmenopause.setEnabled(false);
                }
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        initForm();
    }

    private void initForm() {
        Profile profile = ApplicationModel.get().getCurrentUser().getProfile();
        if (profile != null) {
            heightPicker.setValue(profile.getHeight());
            weightPicker.setValue(profile.getWeight());
            if (Gender.MALE.equals(profile.getGender())) {
                checkMaleButton.setChecked(true);
            } else {
                checkFemaleButton.setChecked(true);
                if (profile.isMenopause()) {
                    checkMenopauseButton.setChecked(true);
                } else {
                    checkNoMenopauseButton.setChecked(true);
                }
            }

            if (profile.isSmoker()) {
            checkSmockerButton.setChecked(true);
            }else {
                checkNotSmockerButton.setChecked(true);
            }
            if (profile.isMarried()) {
                checkMarriedButton.setChecked(true);
            }else {
                checkNotMarriedButton.setChecked(true);
            }
            if (profile.isDiabetic()) {
                checkDiabiticButton.setChecked(true);
            }else {
                checkNotDiabiticButton.setChecked(true);
            }
            if (profile.isDyslipidemic()) {
                checkDyslipidemieButton.setChecked(true);
            }else {
                checkNoDyslipidemieButton.setChecked(true);
            }
            if (profile.isHypertensive()) {
                checkHypertensionButton.setChecked(true);
            }else {
                checkNoHypertensionButton.setChecked(true);
            }
            if (profile.isPersonalAntecedent()) {
                checkPersonalAntecedentButton.setChecked(true);
            }else {
                checkNoPersonalAntecedentButton.setChecked(true);
            }
            if (profile.isFamilyAntecedent()) {
                checkFamilyAntecedentButton.setChecked(true);
            }else {
                checkNoFamilyAntecedentButton.setChecked(true);
            }



        }
    }


    private class SaveOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (!validate()) {
                onUpdateProfileFailure();
                return;
            }
            saveButton.setEnabled(false);
            Gender gender = genderRadioGroup.getCheckedRadioButtonId() == checkFemaleButton.getId() ? Gender.FEMALE : MALE;
            int wheight = weightPicker.getValue() ;
            int height = heightPicker.getValue();
            boolean married = marriedRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkMarried_T).getId();
            boolean smoker = smokerRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkSmoker_T).getId();
            boolean diabetic = diabeticRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkDiabetic_T).getId();
            boolean hypertensive = hypertensionRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkhypertension_T).getId();
            boolean dyslipidemic = dyslipidemieRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkdyslipidemie_T).getId();
            boolean personalAntecedent = personalAntecedentRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkPersonalAntecedent_T).getId();
            boolean familyAntecedent = familyAntecendtRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkFamilyAntecendt_True).getId();
            boolean menopause = rmenopause.getCheckedRadioButtonId()== findViewById(R.id.btn_checkMenopause_T).getId() ;
            Profile profile = new Profile.Builder().newProfile()
                    .withWeight(wheight)
                    .withHeight(height)
                    .withGender(gender)
                    .withMenopause(menopause)
                    .withSmoker(smoker)
                    .withMarried(married)
                    .withDiabetic(diabetic)
                    .withHypertensive(hypertensive)
                    .withDyslipidemic(dyslipidemic)
                    .withPersonalAntecedent(personalAntecedent)
                    .withFamilyAntecedent(familyAntecedent)
                    .build();
            new UpdateProfileAsyncTask(ProfileActivity.this).execute(profile);
        }

    }

    public void onUpdateProfileSuccess() {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
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

    private static class UpdateProfileAsyncTask extends AsyncTask<Profile, Void, Void> {
        private ProgressDialog progress;
        private boolean success = false;
        private ProfileActivity activity;

        UpdateProfileAsyncTask(ProfileActivity activity) {
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
        protected Void doInBackground(Profile... params) {
            try {
                success = ApplicationModel.get().updateCurrentUserProfile(params[0]);
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
                this.activity.onUpdateProfileSuccess();
            } else {
                this.activity.onUpdateProfileFailure();
            }
        }

    }

}
