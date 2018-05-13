package tmc.ensi.org.tmcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.ChronicDisease;

public class HeartRhythmPathologyActivity extends AppCompatActivity {
    RadioGroup pacemaker ;
    RadioGroup defibrillator  ;
    RadioGroup tripleRoom ;
    RadioGroup atrialFibrillation ;
    RadioButton checkPaceMaker  ;
    RadioButton checkDefibrillator ;
    RadioButton checkTripleRoom ;
    RadioButton checkAtrialFibrillation;
    Button nextButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rhythm_pathology);
        pacemaker = (RadioGroup) findViewById(R.id.rg_pacemaker) ;
        defibrillator = (RadioGroup) findViewById(R.id.rg_defibrillator) ;
        tripleRoom = (RadioGroup) findViewById(R.id.rg_pacemaker) ;
        atrialFibrillation = (RadioGroup) findViewById(R.id.rg_atrialFibrillation) ;
        checkPaceMaker = (RadioButton) findViewById(R.id.rb_withpacemaker) ;
        checkDefibrillator = (RadioButton) findViewById(R.id.rb_withDefibrillator) ;
        checkTripleRoom = (RadioButton) findViewById(R.id.rb_withTripleRoom) ;
        checkAtrialFibrillation= (RadioButton) findViewById(R.id.rb_withAtrialFibrillation) ;
        nextButton = findViewById(R.id.btn_save);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean hasPacemaker = pacemaker.getCheckedRadioButtonId() == findViewById(R.id.rb_withpacemaker).getId();
                boolean hasDefibrillator = defibrillator.getCheckedRadioButtonId() == findViewById(R.id.rb_withDefibrillator).getId();
                boolean hasTripleRoom = pacemaker.getCheckedRadioButtonId() == findViewById(R.id.rb_withTripleRoom).getId();
                boolean hasAtrialFibrillation = atrialFibrillation.getCheckedRadioButtonId() == findViewById(R.id.rb_withAtrialFibrillation).getId();
            }
        });

    }
}
