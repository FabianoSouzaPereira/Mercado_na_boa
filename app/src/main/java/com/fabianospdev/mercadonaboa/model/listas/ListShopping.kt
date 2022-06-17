package com.fabianospdev.mercadonaboa.model.listas

import com.fabianospdev.mercadonaboa.model.listas.products.Itens

class ListShopping (
    var name: String,
    var itens: MutableList<Itens>,
    var qtToBuy: Int,
    var qtBought: Int,
    var statusList: String,
    var data: String
)