package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import tmc.ensi.org.tmcapp.adapters.MedicalProblemsAdapter;

public class MedicalProblemsActivity extends AppCompatActivity {
    ArrayList<Integer> problemsImages;
    ArrayList<String> problemsText;
    ListView medicalListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_problems);
        medicalListView = (ListView) findViewById(R.id.listOfProblems);
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fillProblemsImages();
                fillProblemsText();
                tmc.ensi.org.tmcapp.adapters.MedicalProblemsAdapter customMedicalProblemsAdapter = new MedicalProblemsAdapter(MedicalProblemsActivity.this, problemsImages, problemsText);
                medicalListView.setAdapter(customMedicalProblemsAdapter);
            }
        });
        medicalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), DoctorCodeActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        break;
                }
            }
        });
    }
    void fillProblemsImages() {
        problemsImages = new ArrayList();
        problemsImages.add(R.drawable.fever_face);
        problemsImages.add(R.drawable.headache);
        problemsImages.add(R.drawable.cold);
        problemsImages.add(R.drawable.vomiting);
        problemsImages.add(R.drawable.constipation);
    }
    void fillProblemsText() {
        problemsText = new ArrayList();
        String[] problems = getResources().getStringArray(R.array.medicalProblems);

        for (int i = 0; i < problems.length; i++)
            problemsText.add(problems[i]);
    }
}
