package com.example.intentexample;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button phoneButton = (Button) findViewById(R.id.phonecall);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.CALL_PHONE)
                            != PackageManager.PERMISSION_GRANTED){
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 100);
                        Toast.makeText(MainActivity.this, "안드로이드 6.0 마시멜로부터 일부 권한에 대해 사용자에게 동의 필요!",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                Uri uri = Uri.parse("tel:01099990000");
                Intent intent = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent);
            }
        });

        Button textButton = (Button)findViewById(R.id.text);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:01099990000");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Hi");
                startActivity(intent);
            }
        });

        Button emailButton = (Button)findViewById(R.id.email);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("mailto:nasuk0610@gmail.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                try{
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    Toast.makeText(MainActivity.this, "ActivityNotFoundException", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button browserButton = (Button)findViewById(R.id.browser);
        browserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }
}
