package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Firebase.firestore

         save.setOnClickListener{
             var name=  PersonID.text.toString()
             var id=  PersonName.text.toString()
             var age=  PersonAge.text.toString()

             val person = hashMapOf(
                 "name" to name,
                 "id" to id,
                 "age" to age
             )
             db.collection("Persons")
                 .add(person)
                 .addOnSuccessListener { documentReference ->
                     Toast.makeText(applicationContext,"${documentReference.id}",Toast.LENGTH_SHORT).show()

                 }
                 .addOnFailureListener { e ->
                     Toast.makeText(applicationContext,"$e",Toast.LENGTH_SHORT).show()


                 }
         }



//        // Write a message to the database
//        val database = Firebase.database
//        val myRef = database.getReference("message")
//
//        myRef.setValue("Hello, World!")
//        myRef.addValueEventListener(object: ValueEventListener {
//
//            override fun onDataChange(snapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//            }
//
//        })

    }
}