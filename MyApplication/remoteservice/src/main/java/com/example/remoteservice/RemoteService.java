package com.example.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.Toast;

import com.example.remoteservice.RemoteStub;

public class RemoteService extends Service {

    @Override
    public void onCreate(){
        super.onCreate();

        Toast.makeText(this, "[RemoteService] onCreate() 함수 호출", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent arg0){
        Toast.makeText(this, "[RemoteService] onBind() 함수 호출", Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

        Toast.makeText(this, "[RemoteService] onDestroy() 함수 호출", Toast.LENGTH_SHORT).show();
    }

    RemoteStub.Stub mBinder = new RemoteStub.Stub(){

        @Override
        public String getServerPackageName() throws RemoteException {
            return RemoteService.this.getPackageName();
        }
    };

}
