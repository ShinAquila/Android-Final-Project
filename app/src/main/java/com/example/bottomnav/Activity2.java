package com.example.bottomnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    private Button button;
    NotificationManagerCompat notificationManagerCompat;
    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_2);

        button = (Button) findViewById(R.id.back_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){openMainActivity();}


        });


        //PUSH NOTIF
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.0){
//            NotificationChannel channel = new NotificationChannel("myCh", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
//
//            NotificationManager manager = getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }

        //Design of push notif
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myCh")
                .setSmallIcon(android.R.drawable.btn_star_big_on)
                .setContentTitle("Message Received")
                .setContentText("Body of Message");

        notification = builder.build();
        notificationManagerCompat = NotificationManagerCompat.from(this);
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void triggerToastTest(View v){
        Toast.makeText(Activity2.this, "This is a TOAST MESSAGE",Toast.LENGTH_LONG).show();
    }

    public void notif (View v){
        notificationManagerCompat.notify(1, notification);
    }

}