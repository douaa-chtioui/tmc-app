package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.Profile;

public class Weight extends AppCompatActivity {
    private NumberPicker weightPicker;
    private Button nextButton , homePageButton ,retutnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        weightPicker = findViewById(R.id.np_weight);
        weightPicker.setMinValue(30);
        weightPicker.setValue(60);
        weightPicker.setMaxValue(160);
        nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profile profile = ApplicationModel.get().getCurrentUser().getProfile();
                if(profile == null){
                    profile = new Profile();
                    ApplicationModel.get().getCurrentUser().setProfile(profile);
                }
                profile.setWeight(weightPicker.getValue());
                Intent intent = new Intent(getApplicationContext(),Qgender.class);
                startActivity(intent);
            }
        });
        homePageButton = findViewById(R.id.btn_home);
        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserHomeActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        retutnButton = findViewById(R.id.btn_return);
        retutnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
