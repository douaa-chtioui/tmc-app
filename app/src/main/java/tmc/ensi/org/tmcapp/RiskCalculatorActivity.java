package tmc.ensi.org.tmcapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.Gender;
import tmc.ensi.org.tmcapp.model.Profile;

public class RiskCalculatorActivity extends Activity {
    private Button calculatebtn ;
    private float tension , cholesterol ;
    private TextView score ;
    private String m ;
    private int age = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_calculator);
       final EditText edt = (EditText) findViewById(R.id.et2);
        score = findViewById(R.id.tv_score);
        calculatebtn = findViewById(R.id.btn_calculate);
        final Profile profile = ApplicationModel.get().getCurrentUser().getProfile();
        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float number = Float.valueOf(edt.getText().toString());
                if (profile != null) {
                    if (profile.getGender() == Gender.FEMALE && !profile.isSmoker()) {
                      //  if (40>= age && age <= 50 )
                        m = "20%";
                          }
                }


                Intent intent = new Intent(getApplicationContext(),RiskResult.class);
                intent.putExtra("score",m);
                startActivity(intent);

            }

        });
    }
}