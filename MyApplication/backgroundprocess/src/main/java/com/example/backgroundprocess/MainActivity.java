package com.example.backgroundprocess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            String state = savedInstanceState.getString("STATE");
            Toast.makeText(this, "STATE = " + state, Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"No STATE",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle){

        Toast.makeText(this, "Saved state ", Toast.LENGTH_LONG).show();

        bundle.putString("STATE", "FORCE STOP");

        // 프로세스가 Background processㄹ 상태로 변경 되는 경우 호출
        // Background Process가 강제 종료되고 다시 실행 될 때 액티비티의 onCreate 함수의
        // Bundle에서 저장된 상태값을 가져올 수 있다.
    }


}
