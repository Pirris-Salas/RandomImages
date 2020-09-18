package com.pirris.randomimages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    private var urlImage: MutableLiveData<String?>? = null

    fun callUrlImage(): MutableLiveData<String?>?{
        if (urlImage == null){
            urlImage = MutableLiveData<String?>()
           randomUrlImage()
        }

        return urlImage
    }

    //Método que asigna un número random a la URL para alterarla y obtener una nueva imagen
    fun randomUrlImage(){
        urlImage?.value = "https://picsum.photos/${(3..5).random()}00/${(3..5).random()}00"

    }

}