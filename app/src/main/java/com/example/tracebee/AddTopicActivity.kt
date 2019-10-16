package com.example.tracebee

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import kotlinx.android.synthetic.main.activity_add_topic.*


class AddTopicActivity : AppCompatActivity() {

    private val requestImageCapture = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_topic)

        val addPhotoBtn = findViewById<Button>(R.id.addPhotoBtn)
        addPhotoBtn.setOnClickListener {
            dispatchTakePictureIntent(requestImageCapture)
        }
    }
    //hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)



    private fun dispatchTakePictureIntent(REQUEST_IMAGE_CAPTURE: Int) {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{ takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also{
                startActivityForResult(takePictureIntent, 1)
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == requestImageCapture && resultCode == Activity.RESULT_OK){
            val imageBitmap = data?.extras?.get("data") as Bitmap
            addTopicImageView.setImageBitmap(imageBitmap)
        }
    }

}
