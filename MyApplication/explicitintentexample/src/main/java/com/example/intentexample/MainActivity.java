package com.example.intentexample;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
                Toast.makeText(MainActivity.this, "[Intent] 전화걸기", Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("tel:전화번호");
                Intent intent = new Intent(Intent.ACTION_CALL, uri);

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Permission required.", Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(intent);
                }
            }
        });

        Button textButton = (Button)findViewById(R.id.text);
        textButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "[Intent] 문자 보내기", Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("smsto:전화번호");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Hi");
                startActivity(intent);
            }
        });

        Button emailButton = (Button)findViewById(R.id.email);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "[Intent] 이메일 보내기", Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("mailto:nasuk0610@gmail.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                try{
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this,"[Email] fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button browserButton = (Button)findViewById(R.id.browser);
        browserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "[Intent] 브라우저 보내기", Toast.LENGTH_SHORT).show();

                Uri uri = Uri.parse("http://www.naver.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

    }
}
