package tmc.ensi.org.tmcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ToolBarAction extends AppCompatActivity {
    private Button homePageButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_actionbar_with_headerbar);
        homePageButton = findViewById(R.id.btn_home);
        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UserHomeActivity.class);
                startActivity(intent);
            }
        });
    }


}
