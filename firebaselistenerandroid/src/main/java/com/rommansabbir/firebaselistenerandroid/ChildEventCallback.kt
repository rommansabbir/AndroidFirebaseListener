package com.rommansabbir.firebaselistenerandroid

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

interface ChildEventCallback {
    fun onChildAdded(var1: DataSnapshot, var2: String?)
    fun onChildChanged(var1: DataSnapshot, var2: String?)
    fun onChildRemoved(var1: DataSnapshot)
    fun onChildMoved(var1: DataSnapshot, var2: String?)
    fun onCancelled(var1: DatabaseError)
}