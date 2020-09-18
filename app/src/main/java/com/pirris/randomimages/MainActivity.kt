package com.pirris.randomimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var imagePhoto: ImageView = findViewById(R.id.imgPhoto)
        var imagePhoto2: ImageView = findViewById(R.id.imgPhoto2)
        var btnGetUrlImage: Button = findViewById(R.id.btnGetImageUrl)

        var model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        var urlImage: MutableLiveData<String?>? = model.callUrlImage()

        urlImage?.observe(this, Observer {
            Picasso.get().load(it).into(imagePhoto)
            Picasso.get().load(it).into(imagePhoto2)

        })

        btnGetUrlImage.setOnClickListener {
            model.randomUrlImage()
        }

    }
}