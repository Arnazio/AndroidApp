package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.viewmodels.UserViewModel
import com.google.firebase.Firebase
import com.google.firebase.appcheck.appCheck
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import com.google.firebase.initialize


class MainActivity : AppCompatActivity() {

    val admin : Boolean = true;
    //private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        Firebase.initialize(context = this)
        Firebase.appCheck.installAppCheckProviderFactory(
            PlayIntegrityAppCheckProviderFactory.getInstance(),
        )
        val database = FirebaseDatabase.getInstance("https://fitnessapp-c125c-default-rtdb.europe-west1.firebasedatabase.app")
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")
        super.onCreate(savedInstanceState)
        if (admin){
            setContentView(R.layout.dashboard)
        }else{
            setContentView(R.layout.activity_main)
        }
    }

}