package com.tatsuro.app.bottomsheetdialogfragmentsample

/** 収入または支出の種別 */
enum class IncomeOrExpenseType(private val strResId: Int, val drawableResId: Int) {

    SALARY(R.string.salary, R.drawable.ic_icooon_mono_salary_24),
    PENSION(R.string.pension, R.drawable.ic_icooon_mono_pension_24),
    REMITTANCE(R.string.remittance, R.drawable.ic_icooon_mono_remittance_24),
    POCKET_MONEY(R.string.pocket_money, R.drawable.ic_icooon_mono_pocket_money_24),
    BONUS(R.string.bonus, R.drawable.ic_icooon_mono_bonus_24),
    TEMPORARY_INCOME(R.string.temporary_income, R.drawable.ic_icooon_mono_temporary_income_24),
    LOAN(R.string.loan, R.drawable.ic_icooon_mono_loan_24),
    INTEREST(R.string.interest, R.drawable.ic_icooon_mono_interest_24),
    INVESTMENT_INCOME(R.string.investment_income, R.drawable.ic_icooon_mono_investment_income_24),
    SALE_INCOME(R.string.sale_income, R.drawable.ic_icooon_mono_sale_income_24),
    OTHER_INCOME(R.string.other, R.drawable.ic_icooon_mono_other_income_24);

    companion object {

        /**
         * 収入種別の配列を返す。
         * @return 収入種別の配列
         */
        fun incomeTypes(): Array<IncomeOrExpenseType> = arrayOf(
            SALARY,
            PENSION,
            REMITTANCE,
            POCKET_MONEY,
            BONUS,
            TEMPORARY_INCOME,
            LOAN,
            INTEREST,
            INVESTMENT_INCOME,
            SALE_INCOME,
            OTHER_INCOME
        )
    }

    override fun toString(): String {
        return App.getString(strResId)
    }
}
