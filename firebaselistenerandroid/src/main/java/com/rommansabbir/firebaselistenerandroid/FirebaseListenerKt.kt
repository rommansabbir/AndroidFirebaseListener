package com.rommansabbir.firebaselistenerandroid

import android.content.Context
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener


class FirebaseListenerKt(var context : Context){
    private var firebaseDatabase: FirebaseDatabase
    private var listenerInterface: FirebaseListenerInterface

    init {
        this.context = context
        firebaseDatabase = FirebaseDatabase.getInstance()
        listenerInterface = context as FirebaseListenerInterface
    }

    /**
     * Get data from firebase
     * @param refPath
     */
    fun getData(refPath : String){
        val databaseReference = firebaseDatabase.getReference(refPath)
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                listenerInterface.onFirebaseListenerFailure(p0)
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    listenerInterface.onFirebaseListenerSuccess(p0)
                }
            }

        })
    }

    interface FirebaseListenerInterface {
        fun onFirebaseListenerSuccess(dataSnapshot: DataSnapshot)
        fun onFirebaseListenerFailure(databaseError: DatabaseError)
    }
}