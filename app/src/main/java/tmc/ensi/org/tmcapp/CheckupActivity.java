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
import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.Checkup;

public class CheckupActivity extends AppCompatActivity {
    ListView formList ;
    Button btnAdd ;
    Button homePageButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkup);
        formList = (ListView) findViewById(R.id.formList);
        btnAdd = findViewById(R.id.btnAdd);
        homePageButton = findViewById(R.id.btn_home);
        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserHomeActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        CheckupAdapter checkupAdapter = new CheckupAdapter(this, R.layout.item_checkup_form, ApplicationModel.get().getCurrentUser().getCheckups());
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
