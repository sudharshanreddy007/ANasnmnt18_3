package com.sudharshan.user.anasnmnt18_3;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;


//created main activty
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button simple_notification_btn;

    //onCreate method is called when maain activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //it is to find the id from the activity main.xml which layout xml file
        simple_notification_btn = (Button) findViewById(R.id.button);
        //by implementing setOnClickListener by this if we click on button it goes to seconctivtiy
        simple_notification_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//creating builder for notification
         Notification.Builder builder = new Notification.Builder(MainActivity.this)
                .setSmallIcon(R.drawable.lollipop)
                .setContentTitle("Important")
                .setContentText("Messages");

//creating intent
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //created object of pendingIntent
        PendingIntent piResult = PendingIntent.getActivity(this, 0, resultIntent, 0);
        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            notification = new Notification.InboxStyle(builder)
                    //adding Some Notification\.addLine("Hello....!!")
                    .addLine("How are you?????")
                    .addLine("Hi !!!!")
                    .addLine("I'm fine")
                    .addLine("what about you?all is well?")
                    .addLine("yes,everything is all right... ")
                    .setBigContentTitle("Event details")

                    .setSummaryText("+3 more")
                    .build();

        }
        builder.setContentIntent(piResult);

//creating notification manager
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(121, notification);

    }
}