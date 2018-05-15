package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import tmc.ensi.org.tmcapp.model.ApplicationModel;

public class Height extends AppCompatActivity{
    private NumberPicker heightPicker;
    private Button homePageButton , nextButton ,retutnButton ;
    private int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_height);
        heightPicker = findViewById(R.id.np_height);
        heightPicker.setMinValue(140);
        heightPicker.setValue(160);
        heightPicker.setMaxValue(220);
        homePageButton = findViewById(R.id.btn_home);
        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserHomeActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
        nextButton = findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationModel.get().getCurrentUser().getProfile().setHeight(heightPicker.getValue());
                Intent intent = new Intent(getApplicationContext(),Qgender.class);
                startActivity(intent);
                height = heightPicker.getValue();
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

    public int getHeight() {
        return height;
    }
}
