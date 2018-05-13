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
    private RadioGroup mecanicalValveRadioGroup,biologicalValveRadioGroup ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valve_pathology);
        mecanicalValveRadioGroup = findViewById(R.id.rg_mecanicalValve);
        biologicalValveRadioGroup = findViewById(R.id.rg_biologicalValve);
        saveButton = findViewById(R.id.btn_valvePathology);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean hasmecanicalValve = mecanicalValveRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkMecanicalValve).getId();
                boolean hasbiologicalValve = biologicalValveRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkBiologicalValve).getId();
            }
        });



    }



}
