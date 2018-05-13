package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import tmc.ensi.org.tmcapp.model.ApplicationModel;

public class QRenalDiseeas extends AppCompatActivity {
    private RadioButton checkKidneyDiseaseButton ,checkNoKidneyDiseaseButton ;
    private RadioGroup kidneyRadioGroup;
    private Button nextButton , homePageButton ,retutnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrenal_diseeas);
        kidneyRadioGroup = findViewById(R.id.rg_kidneyDisease);
        checkKidneyDiseaseButton = findViewById(R.id.btn_checkKidneyDisease_T);
        checkNoKidneyDiseaseButton = findViewById(R.id.btn_checkKidneyDisease_F);
        nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),QHyperTension.class);
                startActivity(intent);
            }
        });
        homePageButton = findViewById(R.id.btn_home);
        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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