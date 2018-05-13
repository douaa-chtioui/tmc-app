package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import tmc.ensi.org.tmcapp.model.ApplicationModel;

public class QDyslipidemia extends AppCompatActivity {

    private Button nextButton , homePageButton ,retutnButton;
    private RadioGroup dyslipidemieRadioGroup;
    private RadioButton checkDyslipidemieButton ,checkNoDyslipidemieButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qdyslipidemia);
        checkDyslipidemieButton = findViewById(R.id.btn_checkdyslipidemie_T);
        checkNoDyslipidemieButton = findViewById(R.id.btn_checkDyslipidemie_F);
        dyslipidemieRadioGroup = findViewById(R.id.rg_dyslipidemie);
        nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean dyslipidemic = dyslipidemieRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkdyslipidemie_T).getId();
                ApplicationModel.get().getCurrentUser().getProfile().setDyslipidemic(dyslipidemic);
                Intent intent = new Intent(getApplicationContext(),QFamilyAntecedent.class);
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