package com.example.garapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.garapp.databinding.FragmentSelectTypeDocumentBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSelectTypeDocument.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSelectTypeDocument : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding : FragmentSelectTypeDocumentBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSelectTypeDocumentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentSelectTypeDocument.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSelectTypeDocument().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.citizenshipCard.setOnClickListener {
            val fragmentScanDni = FragmentScanFrontDni()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_main_container,fragmentScanDni)
                .addToBackStack(null)
                .commit()
        }*/
        binding.citizenshipCard.setOnClickListener(this)
        binding.foreignerId.setOnClickListener(this)
        binding.specialStayPermit.setOnClickListener(this)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        val fragmentScanDni = FragmentScanFrontDni()
        when(v?.id){
            R.id.citizenship_card -> parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_main_container, fragmentScanDni)
                .addToBackStack(null)
                .commit()
            R.id.foreigner_id -> parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_main_container, fragmentScanDni)
                .addToBackStack(null)
                .commit()
            R.id.special_stay_permit -> parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_main_container, fragmentScanDni)
                .addToBackStack(null)
                .commit()
        }
    }
}