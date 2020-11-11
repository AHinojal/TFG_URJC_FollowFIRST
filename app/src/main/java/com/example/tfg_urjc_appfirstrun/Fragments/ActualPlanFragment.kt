package com.example.tfg_urjc_appfirstrun.Fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment
import com.example.tfg_urjc_appfirstrun.Adapters.ExpandableListAdapter
import com.example.tfg_urjc_appfirstrun.Entities.Session
import com.example.tfg_urjc_appfirstrun.Entities.Week
import com.example.tfg_urjc_appfirstrun.R
import java.util.*
import kotlin.collections.ArrayList


class ActualPlanFragment(listDataWeeks: ArrayList<Week>, listDataSession: HashMap<String, ArrayList<Session>>) : Fragment() {

    // Load lists
    var listDataWeeks: ArrayList<Week> = listDataWeeks
    var listDataSession: HashMap<String, ArrayList<Session>> = listDataSession
    // Extendable List View
    var listAdapter: ExpandableListAdapter? = null
    var expListView: ExpandableListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v = inflater?.inflate(R.layout.fragment_actual_plan, container, false)


        // get the listview
        expListView = v.findViewById(R.id.lvExp)

        listAdapter = ExpandableListAdapter(context!!, listDataWeeks!!, listDataSession!!)

        // setting list adapter
        expListView!!.setAdapter(listAdapter)

        expListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            // Introducir ir a seccion concreta
            false
        }

        return v
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        open fun onFragmentInteraction(uri: Uri?)
    }
}
