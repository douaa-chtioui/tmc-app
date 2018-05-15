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

public class DoctorCheckupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView formList;
        Button btnAdd;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_checkup);
        formList = (ListView) findViewById(R.id.formList);
        btnAdd = findViewById(R.id.btnAdd);
        final ArrayList<Checkup> checkups = new ArrayList<>();
        Checkup c1 = new Checkup();
        c1.setCheckupDate(new Date());
        c1.setPatientComment("Question");
        c1.setDoctorComment("Response");
        checkups.add(c1);
        Checkup c2 = new Checkup();
        c2.setCheckupDate(new Date());
        c2.setPatientComment("Question");
        checkups.add(c2);
        CheckupAdapter checkupAdapter = new CheckupAdapter(this, R.layout.item_checkup_form, checkups);
        formList.setAdapter(checkupAdapter);
        formList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (checkups.get(position).getDoctorComment()==null){
                Intent intent = new Intent(DoctorCheckupActivity.this, DoctorCheckupReply.class);
                    intent.putExtra("question",checkups.get(position).getPatientComment());
                startActivity(intent);}
                else {  Intent intent = new Intent(DoctorCheckupActivity.this, DoctorCheckupDetailsActivity.class);
                intent.putExtra("question",checkups.get(position).getPatientComment());
                intent.putExtra("response",checkups.get(position).getDoctorComment());
                    startActivity(intent);}
            }
        });
    }
}