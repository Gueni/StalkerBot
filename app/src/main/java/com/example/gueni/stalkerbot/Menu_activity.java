package com.example.gueni.stalkerbot;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;


public class Menu_activity extends Activity {
    ImageView tracker;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
        tracker = findViewById(R.id.imageView1);
        TextView about = findViewById(R.id.textView1);
        OnClickListener A = new OnClickListener() {
            @Override
            public void onClick(View v) {
                context = getApplicationContext();
                Intent intent = new Intent(context, Devices_list.class);
                startActivity(intent);
            }
        };
        tracker.setOnClickListener(A);
        OnClickListener B = new OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog alertDialog = new AlertDialog.Builder(Menu_activity.this).create();
                alertDialog.setTitle("About this app");
                alertDialog.setMessage("Created By :\n"+"  Mohamed Gueni \n" +"  Cyrine Sfar \n"+"  Mohamed Mehdi ben Henda \n"+ "\n");

                alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Check more on Github",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Uri uri = Uri.parse("https://github.com/Gueni/StalkerBot");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                            }
                        });

                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                alertDialog.show();
            }
        };
        about.setOnClickListener(B);
    }
}
