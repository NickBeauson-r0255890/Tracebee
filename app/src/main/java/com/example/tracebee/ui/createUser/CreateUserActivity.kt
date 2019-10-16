package com.example.tracebee.ui.createUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Spinner
import com.example.tracebee.AddTopicActivity
import com.example.tracebee.HomeScreenActivity
import com.example.tracebee.R
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)


        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.currencies,
            android.R.layout.simple_spinner_item
        ).also{ adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        var normalArray = arrayListOf<Country>()
        fun preparedata(){
                for(countryCode in Locale.getISOCountries()){
                    val locale = Locale("", countryCode)
                    var countryName: String? = locale.displayCountry
                    if(countryName == null){
                        countryName = "UnIdentified"
                    }
                    val simpleCountry = Country(countryName, countryCode)
                    normalArray.add(simpleCountry)
                }
            normalArray = ArrayList(normalArray.sortedWith(compareBy{it.countryName}))
        }



        val textView: AutoCompleteTextView = findViewById(R.id.countries_list)
        val countries = resources.getStringArray(R.array.countries)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        textView.setAdapter(adapter)


        //Go to home screen
        val addUserBtn = findViewById<Button>(R.id.registerNewUser)
        addUserBtn.setOnClickListener {
            startActivity(Intent(this, HomeScreenActivity::class.java))
        }
    }
}

data class Country(val countryName:String, val countryCode:String){}