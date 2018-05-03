package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QDiabetes extends AppCompatActivity {
    private Button nextButton , homePageButton ,retutnButton;
    private RadioGroup diabeticRadioGroup;
    private RadioButton checkDiabiticButton ,checkNotDiabiticButton ;
    private boolean diabitic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qdiabetes);
        checkDiabiticButton = findViewById(R.id.btn_checkDiabetic_T);
        checkNotDiabiticButton = findViewById(R.id.btn_checkDiabetic_F);
        diabeticRadioGroup = findViewById(R.id.rg_diabetic);
        nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),QRenalDiseeas.class);
                startActivity(intent);
                diabitic = diabeticRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkDiabetic_T).getId();
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

    public boolean isDiabitic() {
        return diabitic;
    }
}