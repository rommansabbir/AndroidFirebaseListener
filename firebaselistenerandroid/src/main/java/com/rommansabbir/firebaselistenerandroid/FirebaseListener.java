package com.rommansabbir.firebaselistenerandroid;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseListener {
    private Context context;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseListenerCallbackInterface callbackInterface;

    public FirebaseListener(Context context) {
        this.context = context;
        firebaseDatabase = FirebaseDatabase.getInstance();
        callbackInterface = (FirebaseListenerCallbackInterface) context;
    }


    /**
     * Get data from firebase
     * @param refPath
     */
    public void getData(String refPath) {
        DatabaseReference databaseReference = firebaseDatabase.getReference(refPath);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    callbackInterface.onFirebaseListenerSuccess(dataSnapshot);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callbackInterface.onFirebaseListenerFailure(databaseError);
            }
        });


    }

    /**
     * Destroy the callback after it usages
     */
    public void destroyCallback(){
        firebaseDatabase = null;
        callbackInterface = null;
        context = null;
    }

    public interface FirebaseListenerCallbackInterface{
        void onFirebaseListenerSuccess(DataSnapshot dataSnapshot);
        void onFirebaseListenerFailure(DatabaseError databaseError);
    }
}
