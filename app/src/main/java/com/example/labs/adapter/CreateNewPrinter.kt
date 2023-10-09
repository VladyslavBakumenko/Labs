package com.example.labs.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.labs.databinding.AddNewDialogBinding


class DialogEditUserNameFragment : DialogFragment(com.example.labs.R.layout.add_new_dialog) {

    var onCreateNewPrinterListener: OnCreateNewPrinterListener? = null

    private lateinit var binding: AddNewDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddNewDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if (binding.etFirstName.text.isNotEmpty() && binding.etLastName.text.isNotEmpty()) {
                onCreateNewPrinterListener?.onCreateNewPrinterListener(
                    binding.etFirstName.text.toString(),
                    binding.etLastName.text.toString().toInt()
                )
            }
            dismiss()
        }
    }

    interface OnCreateNewPrinterListener {
        fun onCreateNewPrinterListener(printerName: String, cost: Int)
    }

    companion object {
        fun newInstance(): DialogEditUserNameFragment {
            return DialogEditUserNameFragment()
        }
    }
}