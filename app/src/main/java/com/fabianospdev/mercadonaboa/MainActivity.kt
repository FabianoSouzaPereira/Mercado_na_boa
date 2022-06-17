package com.fabianospdev.mercadonaboa

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabianospdev.mercadonaboa.adapters.AdapterCardHome
import com.fabianospdev.mercadonaboa.model.listas.ListShopping
import com.fabianospdev.mercadonaboa.model.listas.products.Categoria
import com.fabianospdev.mercadonaboa.model.listas.products.Fabricante
import com.fabianospdev.mercadonaboa.model.listas.products.Itens
import com.fabianospdev.mercadonaboa.model.listas.products.Products
import com.fabianospdev.mercadonaboa.utils.Dates


class MainActivity : AppCompatActivity() {
    private lateinit var mContext: Context
    private lateinit var mAdapterCardHome: AdapterCardHome
    private lateinit var rvListRecyclerView: RecyclerView
    private lateinit var list: MutableList<ListShopping>
    private lateinit var btnList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        list = arrayListOf()

        initComponents()

        val categoria: Categoria = Categoria("limpeza")
        val fabricante = Fabricante("Homo")
        val product1 = Products(1, "sabão", categoria, fabricante, 24.80)
        val product2 = Products(2, "sabão neutro", categoria, fabricante, 14.80)

        val item1 = Itens(product1,2.22,2)
        val item2 = Itens(product2,4.25,5)
        val itens: MutableList<Itens> = arrayListOf()
        itens.add(item1)
        itens.add(item2)


        val shopping = ListShopping("Lista compras", itens, 2, 2, "Concluido", Dates().stringToDate()?: "")
        list.add(shopping)
        list.add(shopping)
        list.add(shopping)
        list.add(shopping)
        list.add(shopping)

        initializeAdapter()

        btnList.setOnClickListener {
            val addListFragment = AddListFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.activity_main, addListFragment)
                .addToBackStack("activity_main").commit()
        }
    }

    private fun initComponents() {
        rvListRecyclerView = findViewById(R.id.rvCards)
        btnList = findViewById(R.id.btnList)

    }

    private fun initializeAdapter() {
        rvListRecyclerView.layoutManager = LinearLayoutManager(mContext,RecyclerView.HORIZONTAL, false)
        mAdapterCardHome = AdapterCardHome(mContext){ itemChoice() }
        rvListRecyclerView.adapter = mAdapterCardHome
        mAdapterCardHome.setData(list.toMutableList())
    }

    fun itemChoice() {
        Toast.makeText(mContext, "Item clicado", Toast.LENGTH_LONG).show()
    }
}