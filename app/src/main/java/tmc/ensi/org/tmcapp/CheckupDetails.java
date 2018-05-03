package tmc.ensi.org.tmcapp;

import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import tmc.ensi.org.tmcapp.model.Checkup;

public class CheckupDetails extends AppCompatActivity {
    private LinearLayout doctorlayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkup_details);
        doctorlayout = findViewById(R.id.ll_doctor);
       // doctorlayout.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.doctor1, null));

    }
}
