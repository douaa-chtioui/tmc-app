package tmc.ensi.org.tmcapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import tmc.ensi.org.tmcapp.model.ApplicationModel;
import tmc.ensi.org.tmcapp.model.UserNotification;

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            UserNotification userNotification = new FetchUserNotificationTask().execute().get();
            Notification notification = new NotificationCompat.Builder(context)
                    .setContentTitle("Tiltle")
                    .setContentText(userNotification.getText())
                    .setSmallIcon(android.R.drawable.stat_notify_chat)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT).build();
            notificationManager.notify(1, notification);
        } catch (Exception e) {
            Log.e("", "", e);
        }

    }

    private static class FetchUserNotificationTask extends AsyncTask<Void, Void, UserNotification> {
        @Override
        protected UserNotification doInBackground(Void... voids) {
            return ApplicationModel.get().fetchNotification();
        }
    }

}
