package org.senac.gabrielkraetzer.repository

class Tip(val amount: Double, val tipPercent: Double) {


    public fun returnTipFixed() : Double {
        return calcTip(15.0)
    }

    public fun returnTipPercent() : Double {
        return calcTip(tipPercent)
    }

    private fun calcTip(rate : Double) : Double {
        if (amount == 0.0)
            return 0.0

        return (rate * amount) / 100
    }
}