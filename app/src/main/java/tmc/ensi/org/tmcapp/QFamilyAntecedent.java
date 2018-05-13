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
import tmc.ensi.org.tmcapp.model.ChronicDisease;
import tmc.ensi.org.tmcapp.model.Gender;
import tmc.ensi.org.tmcapp.model.Profile;

import static tmc.ensi.org.tmcapp.model.Gender.FEMALE;
import static tmc.ensi.org.tmcapp.model.Gender.MALE;

public class QFamilyAntecedent extends AppCompatActivity {
    private RadioGroup familyAntecendtRadioGroup;
    private Button nextButton;
    private Button  homePageButton ,retutnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qfamily_antecedent);
        nextButton = findViewById(R.id.btn_next);
        familyAntecendtRadioGroup =  findViewById(R.id.rg_familyAntecedent);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean familyAntecedent = familyAntecendtRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkFamilyAntecendt_True).getId();
                ApplicationModel.get().getCurrentUser().getProfile().setFamilyAntecedent(familyAntecedent);
                Intent intent = new Intent(getApplicationContext(),QChronicdisease.class);
                startActivity(intent);
            }
        });
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

}