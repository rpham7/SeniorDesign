abstract class MeasurementConversion {

    fun heightConversion(feet: Int, inch: Int): Double {
        var valForConversion: Int = feet * 12
        valForConversion += inch

        return valForConversion*0.0254
    }

    fun weightConversion(lbs: Int): Double {
        return lbs/2.205
    }

    fun bmi(height: Double, weight: Double): Double {
        return (height/(weight*weight))*703
    }
}