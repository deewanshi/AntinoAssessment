package com.example.deewanshigrover.firebaseapp;

import android.nfc.Tag;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by DEEWANSHI GROVER on 04-11-2018.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private  static final String TAG="MyFirebaseInsIdService";
    @Override
    public void onTokenRefresh() {
        String refreshedToken= FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"New Token: "+refreshedToken);
    }
}
