package tmc.ensi.org.tmcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DoctorCheckupReply extends AppCompatActivity {
    private TextView question  ;
    private Button send ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_checkup_reply);
        String quest = getIntent().getStringExtra("question");
        question = findViewById(R.id.tv_patientComment);
        question.setText(quest);
    }
}
