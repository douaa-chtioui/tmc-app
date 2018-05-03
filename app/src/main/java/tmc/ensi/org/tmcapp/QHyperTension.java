package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class QHyperTension extends AppCompatActivity {

    private Button nextButton , homePageButton ,retutnButton;
    private boolean hypertensive;
    private RadioGroup hypertensionRadioGroup ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qhyper_tension);
        nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QDyslipidemia.class);
                startActivity(intent);
                hypertensive = hypertensionRadioGroup.getCheckedRadioButtonId() == findViewById(R.id.btn_checkhypertension_T).getId();
            }
        });
        homePageButton = findViewById(R.id.btn_home);
        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserHomeActivity.class);
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

    public boolean isHypertensive() {
        return hypertensive;
    }
}
