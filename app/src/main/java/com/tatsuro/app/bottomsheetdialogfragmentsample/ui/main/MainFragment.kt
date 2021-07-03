package com.tatsuro.app.bottomsheetdialogfragmentsample.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.tatsuro.app.bottomsheetdialogfragmentsample.IncomeOrExpenseType
import com.tatsuro.app.bottomsheetdialogfragmentsample.R
import com.tatsuro.app.bottomsheetdialogfragmentsample.databinding.MainFragmentBinding
import com.tatsuro.app.bottomsheetdialogfragmentsample.ui.typeselect.TypeSelectBottomSheet

/** メインフラグメント */
class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {

        /** 種類選択ボトムシートから選択された種類を取得するためのリクエストキー */
        private const val REQUEST_KEY_TYPE_SELECT = "typeSelect"

        /**
         * フラグメントのインスタントを返す。
         * @return フラグメントインスタント
         */
        fun newInstance() = MainFragment()
    }

    private var toast: Toast? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = MainFragmentBinding.bind(view)

        // 種類選択ボトムシートから選択された種類を取得する。
        setFragmentResultListener(REQUEST_KEY_TYPE_SELECT) { _, bundle ->
            val selectedType =
                bundle.getSerializable(TypeSelectBottomSheet.EXTRA_ENUM_SELECTED_TYPE)

            // Serializable?からIncomeOrExpenseTypeにキャストする。
            if (selectedType is IncomeOrExpenseType) {
                Log.d("MainFragment", "selectedType: ${selectedType.name}")
                showToast("${selectedType}がクリックされました")
            }
        }

        binding.showButton.setOnClickListener {
            val bottomSheet = TypeSelectBottomSheet.newInstance(REQUEST_KEY_TYPE_SELECT)
            bottomSheet.show(parentFragmentManager, bottomSheet.toString())
        }
    }

    /**
     * トーストを表示する。
     *
     * すでにトーストを表示している場合には、その表示中のトースト表示をキャンセルする。
     * @param text 表示するテキスト
     */
    private fun showToast(text: CharSequence) {
        if (toast != null) {
            toast!!.cancel()
            toast = null
        }
        val toast = Toast.makeText(
            requireContext(), text, Toast.LENGTH_SHORT)
        toast.show()
        this.toast = toast
    }
}
