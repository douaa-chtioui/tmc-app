package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import tmc.ensi.org.tmcapp.model.ApplicationModel;

public class QSmoking extends AppCompatActivity {
    private RadioGroup  smokerRadioGroup ;
    private RadioButton checkSmockerButton, checkNotSmockerButton ;
    private Button nextButton , homePageButton ,retutnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qsmoking);
        checkSmockerButton = findViewById(R.id.btn_checkSmoker_T);
        checkNotSmockerButton = findViewById(R.id.btn_checkSmoker_F);
        smokerRadioGroup = findViewById(R.id.rg_smoker);
        nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean   smoker = smokerRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkSmoker_T).getId();
                ApplicationModel.get().getCurrentUser().getProfile().setSmoker(smoker);
                Intent intent = new Intent(getApplicationContext(),QDiabetes.class);
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
