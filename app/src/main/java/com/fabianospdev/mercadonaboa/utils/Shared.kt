package com.fabianospdev.mercadonaboa.utils

import com.fabianospdev.mercadonaboa.model.listas.ListShopping
import com.fabianospdev.mercadonaboa.model.listas.products.Products

class Shared {

    companion object {
        @JvmStatic
        var instance = Shared()
    }

    init {
        instance = this
    }

    var listShopping: MutableList<ListShopping> = arrayListOf()
    var products: MutableList<Products> = arrayListOf()
}