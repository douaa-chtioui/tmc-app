package tmc.ensi.org.tmcapp;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import tmc.ensi.org.tmcapp.adapters.CheckupAdapter;
import tmc.ensi.org.tmcapp.model.Checkup;

public class DoctorCheckupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ListView formList ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_checkup);
        formList = (ListView) findViewById(R.id.formList);
        ArrayList<Checkup> checkups = new ArrayList<>();
        CheckupAdapter checkupAdapter = new CheckupAdapter(this, R.layout.item_checkup_form, checkups);
        formList.setAdapter(checkupAdapter);
        formList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DoctorCheckupActivity.this , CheckupDetails.class);
                startActivity(intent);
            }
        });
    }

}
