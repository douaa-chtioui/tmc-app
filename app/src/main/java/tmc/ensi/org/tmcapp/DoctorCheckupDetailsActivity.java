package tmc.ensi.org.tmcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DoctorCheckupDetailsActivity extends AppCompatActivity {
    private TextView question  ;
    private TextView response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_checkup_details);
        String quest = getIntent().getStringExtra("question");
        String resp = getIntent().getStringExtra("response");
        question = findViewById(R.id.tv_patientComment);
        response = findViewById(R.id.tv_doctorcomment);
        question.setText(quest);
        response.setText(resp);
    }
}
