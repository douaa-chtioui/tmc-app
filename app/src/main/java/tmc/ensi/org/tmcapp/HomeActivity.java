package tmc.ensi.org.tmcapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button profileButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        profileButton = findViewById(R.id.btn_profile);
        profileButton.setOnClickListener(new ProfileOnClickListener());
        scheduleNotifications();
    }

    private void scheduleNotifications() {
        Intent intent = new Intent(getApplicationContext(), NotificationBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 42, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, 5 * 1000, 5 * 1000, pendingIntent);
    }

    private class ProfileOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            // Start the Signup activity
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);
        }

    }

}
