package com.rommansabbir.firebaselistenerandroid

import com.google.firebase.database.*
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener


class FirebaseListener{
    /**
     * Get data from firebase
     * @param refPath
     * @param callback
     */
    fun valueEventListener(refPath : String, callback: ValueEventCallback){
        val databaseReference = FirebaseDatabase.getInstance().getReference(refPath)
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                callback.onFailure(p0)
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    callback.onSuccess(p0)
                }
            }

        })
    }

    /**
     * Get data from firebase
     * @param refPath
     * @param callback
     */
    fun childEventListener(refPath : String, callback: ChildEventCallback){
        val databaseReference = FirebaseDatabase.getInstance().getReference(refPath)
        databaseReference.addChildEventListener(object : ChildEventListener{
            override fun onCancelled(p0: DatabaseError) {
                callback.onCancelled(p0)
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                callback.onChildMoved(p0, p1)
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                callback.onChildChanged(p0, p1)
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                callback.onChildAdded(p0,p1)
            }

            override fun onChildRemoved(p0: DataSnapshot) {
                callback.onChildRemoved(p0)
            }

        })
    }

    /**
     * Get data from firebase
     * @param refPath
     * @param callback
     */
    fun singleEventListener(refPath : String, callback: ValueEventCallback){
        val databaseReference = FirebaseDatabase.getInstance().getReference(refPath)
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
                onCancelled(p0)
            }
            override fun onDataChange(p0: DataSnapshot) {
                callback.onSuccess(p0)
            }

        })

    }

}