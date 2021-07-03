package com.tatsuro.app.bottomsheetdialogfragmentsample.ui.typeselect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tatsuro.app.bottomsheetdialogfragmentsample.IncomeOrExpenseType
import com.tatsuro.app.bottomsheetdialogfragmentsample.databinding.TypeSelectBottomSheetBinding

/** 種類選択ボトムシート */
class TypeSelectBottomSheet : BottomSheetDialogFragment() {

    companion object {

        const val EXTRA_ENUM_SELECTED_TYPE =
            "com.tatsuro.app.bottomsheetdialogfragmentsample.EXTRA_ENUM_SELECTED_TYPE"

        /** 引数リクエストキー */
        private const val ARG_REQUEST_KEY = "requestKey"

        /**
         * フラグメントのインスタントを返す。
         * @param requestKey 選択された種類を受け渡すためのリクエストキー
         * @return フラグメントインスタント
         */
        fun newInstance(requestKey: String) = TypeSelectBottomSheet().apply {
                arguments = bundleOf(ARG_REQUEST_KEY to requestKey)
            }
    }

    private var _binding: TypeSelectBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = TypeSelectBottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val requestKey = requireArguments().getString(ARG_REQUEST_KEY)

        binding.apply {
            toolbar.setNavigationOnClickListener {
                dismiss()
            }

            typeRecyclerView.apply {
                layoutManager = GridLayoutManager(
                    requireContext(), 3, RecyclerView.VERTICAL, false)
                adapter = TypeAdapter(IncomeOrExpenseType.incomeTypes()) { type ->
                    requestKey?.let { key ->
                        // 選択された種類を親フラグメントに返す。
                        setFragmentResult(
                            key, bundleOf(
                                EXTRA_ENUM_SELECTED_TYPE to type
                            )
                        )
                    }

                    dismiss()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
