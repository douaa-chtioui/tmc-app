package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class QMenopause extends AppCompatActivity {
    private RadioGroup rmenopause ;
    private RadioButton checkMenopauseButton,checkNoMenopauseButton;
    private Button nextButton , homePageButton ,retutnButton;
    boolean menopause ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qmenopause);
        checkMenopauseButton = findViewById(R.id.btn_checkMenopause_T);
        checkNoMenopauseButton = findViewById(R.id.btn_checkMenopause_F);
        rmenopause = findViewById(R.id.rg_menopause);
        nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),QSmoking.class);
                startActivity(intent);
                menopause = rmenopause.getCheckedRadioButtonId()== findViewById(R.id.btn_checkMenopause_T).getId() ;

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

    public boolean isMenopause() {
        return menopause;
    }
}
