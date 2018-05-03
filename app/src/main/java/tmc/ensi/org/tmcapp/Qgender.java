package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import tmc.ensi.org.tmcapp.model.Gender;

import static tmc.ensi.org.tmcapp.model.Gender.MALE;

public class Qgender extends AppCompatActivity {
    private Button nextButton , homePageButton ,retutnButton;
    private RadioButton checkFemaleButton, checkMaleButton ;
    private RadioGroup genderRadioGroup;
    private Gender gender ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qgender);
        genderRadioGroup = findViewById(R.id.rg_gender);
        checkFemaleButton = findViewById(R.id.btn_checkFemale);
        checkMaleButton = findViewById(R.id.btn_checkMale);
        nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (genderRadioGroup.getCheckedRadioButtonId() == checkFemaleButton.getId())
                {
                    Intent intent = new Intent(getApplicationContext(),QMenopause.class);
                    startActivity(intent);
                    gender = genderRadioGroup.getCheckedRadioButtonId() == checkFemaleButton.getId() ? Gender.FEMALE : MALE;
                } else {
                    Intent intent = new Intent(getApplicationContext(),QSmoking.class);
                    startActivity(intent);
                }

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

    public Gender getGender() {
        return gender;
    }
}
