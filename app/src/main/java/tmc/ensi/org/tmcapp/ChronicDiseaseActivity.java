package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import tmc.ensi.org.tmcapp.adapters.ChronicDiseaseAdapter;
import tmc.ensi.org.tmcapp.model.ChronicDisease;
import tmc.ensi.org.tmcapp.model.Disease;

public class ChronicDiseaseActivity extends AppCompatActivity {


    ArrayList<Integer> diseaseImages;
    ArrayList<String> diseaseText;
    ListView diseaseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronic_disease);
       diseaseListView = (ListView) findViewById(R.id.listOfDiseases);
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                fillProblemsImages();
                fillProblemsText();
                tmc.ensi.org.tmcapp.adapters.ChronicDiseaseAdapter customChronicDiseaseAdapter = new ChronicDiseaseAdapter(ChronicDiseaseActivity.this, diseaseImages, diseaseText);
                diseaseListView.setAdapter(customChronicDiseaseAdapter);
            }
        });
        diseaseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Disease disease = null ;
                switch (i) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), CoronaryPathologyActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(), ValvePathologyActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), HeartRhythmPathologyActivity.class));
                        break;
                }

            }
        });
    }
    void fillProblemsImages() {
        diseaseImages = new ArrayList();
        diseaseImages.add(R.drawable.fever_face);
        diseaseImages.add(R.drawable.headache);
        diseaseImages.add(R.drawable.cold);
        diseaseImages.add(R.drawable.vomiting);
        diseaseImages.add(R.drawable.constipation);
    }
    void fillProblemsText() {
        diseaseText = new ArrayList();
        String[] problems = getResources().getStringArray(R.array.chronicDiseases);

        for (int i = 0; i < problems.length; i++)
            diseaseText.add(problems[i]);
    }
}
