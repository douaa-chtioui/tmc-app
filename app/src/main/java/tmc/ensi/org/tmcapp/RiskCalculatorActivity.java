package tmc.ensi.org.tmcapp;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RiskCalculatorActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_calculator);
        final EditText et = (EditText) findViewById(R.id.et);
        final EditText et2 = (EditText) findViewById(R.id.et2);
        et.setBackgroundResource(R.drawable.edittext_bg);
        et2.setBackgroundResource(R.drawable.edittext_bg);
    }
}