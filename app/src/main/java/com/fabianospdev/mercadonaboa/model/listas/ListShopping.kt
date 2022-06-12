package com.fabianospdev.mercadonaboa.model.listas

import com.fabianospdev.mercadonaboa.model.listas.products.Products

class ListShopping (
    var name: String,
    var products: MutableList<Products>,
    var qtToBuy: Int,
    var qtBought: Int,
    var statusList: String,
    var data: String
)