package com.fabianospdev.mercadonaboa

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fabianospdev.mercadonaboa.adapters.AdapterAddList


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var rvListRecyclerView: RecyclerView
    private lateinit var mContext: Context
    private lateinit var mAdapterAddList: AdapterAddList
    private lateinit var mList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = requireContext()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_add_list, container, false)

        rvListRecyclerView =  root.findViewById(R.id.rvTypeList)
        mList = arrayListOf()
        initializeAdapter()

        return root
    }

    private fun initializeAdapter() {
        rvListRecyclerView.layoutManager = LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        mAdapterAddList = AdapterAddList(mContext){ clicked() }
        rvListRecyclerView.adapter = mAdapterAddList
        mAdapterAddList.setData(mList.toMutableList())
    }

    private fun clicked() {
        Toast.makeText(mContext, "Item clicado", Toast.LENGTH_LONG).show()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}