package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import tmc.ensi.org.tmcapp.adapters.CheckupAdapter;
import tmc.ensi.org.tmcapp.model.Checkup;

public class CheckupActivity extends AppCompatActivity {
    ListView formList ;
    Button btnAdd ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkup);
        formList = (ListView) findViewById(R.id.formList);
        btnAdd = findViewById(R.id.btnAdd);
        ArrayList<Checkup> checkups = new ArrayList<>();
        Checkup c1 = new Checkup();
        c1.setDate(new Date());
        c1.setPatientComment("Question");
        c1.setDoctorComment("Response");
        checkups.add(c1);
        Checkup c2 = new Checkup();
        c2.setDate(new Date());
        c2.setPatientComment("Question");
        checkups.add(c2);
        CheckupAdapter checkupAdapter = new CheckupAdapter(this, R.layout.item_checkup_form, checkups);
        formList.setAdapter(checkupAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckupActivity.this,CheckupForm.class);
                startActivity(intent);
            }
        });
        formList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CheckupActivity.this , CheckupDetails.class);
                startActivity(intent);
            }
        });
    }

}
