package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.Gender;
import tmc.ensi.org.tmcapp.model.Profile;

public class FinalProfilActivity extends AppCompatActivity {
    private TextView smoker  ;
    private TextView menopause;
    private TextView age ;
    private TextView height;
    private TextView weight ;
    private TextView diabetes ;
    private TextView dyslipidemia ;
    private TextView hypertension ;
    private TextView personnelAntecedent ;
    private TextView familyAntecedent ;
    private TextView chronicDisease ;
    private TextView name ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_final);
        smoker = findViewById(R.id.tv_smoker);
        menopause = findViewById(R.id.tv_menopaue);
        height = findViewById(R.id.tv_height);
        weight = findViewById(R.id.tv_weight);
        diabetes = findViewById(R.id.tv_diabete);
        dyslipidemia = findViewById(R.id.tv_dyslipidimic);
        hypertension = findViewById(R.id.tv_hypertension);
        personnelAntecedent = findViewById(R.id.tv_personnelAntecedent);
        familyAntecedent = findViewById(R.id.tv_familyAntecedent);
        name = findViewById(R.id.tv_name);
        ImageView img = (ImageView) findViewById(R.id.im_modifyProfil);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Weight.class);
                startActivity(intent);
                finish();
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
            if (profile.getGender() == Gender.MALE) {
                if (profile.isSmoker()) {
                    smoker.setText("Fumeur");
                } else {
                    smoker.setText("Non fumeur");
                }
                if (profile.isHypertensive()) {
                    hypertension.setText("hypertensif");
                } else {
                    hypertension.setText("Non hypertensif");
                }

            } else {
                if (profile.isSmoker()) {
                    smoker.setText("Fumeuse");
                } else {
                    smoker.setText("Non fumeuse");
                }
                if (profile.isMenopause()) {
                    menopause.setText("Ménopausée");
                    menopause.setTextSize(25);
                } else {
                    menopause.setText("Non Ménopausée");
                    menopause.setTextSize(25);
                }
                if (profile.isHypertensive()) {
                    hypertension.setText("hypertensive");
                } else {
                    hypertension.setText("Non hypertensive");
                }
            }
            if (profile.isFamilyAntecedent()) {
                familyAntecedent.setText("Avec des antecedents familiaux");
            }
            if (profile.isFamilyAntecedent()) {
                personnelAntecedent.setText("Avec des antecedents personnelles");
            }

            height.setText(String.valueOf(profile.getHeight()));
            // weight.setText(String.valueOf(profile.getWeight()));
            //name.setText(ApplicationModel.get().getCurrentUser().getFirstname());
            if (profile.isDiabetic()) {
                diabetes.setText("Diabétique");
            } else {
                diabetes.setText("Non diabétique");
            }
            if (profile.isDyslipidemic()) {
                dyslipidemia.setText("Dyslipidémique");
            } else {
                dyslipidemia.setText("Non dyslipidémique");
            }
        }
    }

    }
