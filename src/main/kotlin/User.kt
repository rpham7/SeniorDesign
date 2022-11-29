import com.sun.jdi.IntegerValue

class User {
    private var age: Int = 0
    private var weight: Double = 0.0
    private var height: Double = 0.0
    private var bodyFat: Double = 0.0
    private var gender: String = ""
    private var goal: String = ""
    private var walkTime: Double = 0.0
    private var heartRate: Double = 0.0
    private var fitLevel: String = ""
    private lateinit var workout:MutableMap<String, String>

    constructor(age: Int, weight: Double, height: Double, bodyFat: Double, goal: String, gender:String, time:Double, rate:Double) {
        this.age = age
        this.weight = weight
        this.height = height
        this.bodyFat = bodyFat
        this.goal = goal
        this.gender = gender
        this.walkTime = time
        this.heartRate = rate
        this.fitLevel = fitLevel()
    }

    fun getWeight(): Double {
        return weight
    }

    fun getHeight(): Double {
        return height
    }

    fun getBodyFat(): Double {
        return bodyFat
    }

    fun getGoal(): String {
        return goal
    }

    fun setWorkout(workouts: MutableMap<String, String>){
        workout = workouts
    }

    fun getfitLevel(): String {
        return fitLevel()
    }

    fun extractWorkout() {
        val temp = SQLExtraction("root", "7230")
        this.workout = temp.extractWorkouts()
    }

    fun getWorkout(): MutableMap<String, String> {
        return workout
    }

    fun VO2Max(): Double {
        var value: Double = 132.853 - (0.07769*this.weight) - (0.3877*this.age)
        var temp: Double = 0.0

        if(this.gender.equals("Male")) {
            temp = 6.315
        }

        val value2 = temp - 3.2649*this.walkTime - (0.1565*this.heartRate)
        value += value2

        return value
    }

    fun fitLevel(): String {
        var vO2Max = VO2Max()
        if (this.gender.equals("Male")) {
            if (this.age > 13 && this.age < 19) {
                if (vO2Max < 25.0)
                    return "Very Poor"
                else if (vO2Max >= 25.0 && vO2Max < 31)
                    return "Poor"
                else if (vO2Max >= 31.0 && vO2Max < 35)
                    return "Fair"
                else if (vO2Max >= 35.0 && vO2Max < 39)
                    return "Good"
                else if (vO2Max >= 39.0 && vO2Max < 42)
                    return "Excellent"
                else
                    return "Superior"
            }
            if (this.age >= 20 && this.age < 30) {
                if (vO2Max < 23.6)
                    return "Very Poor"
                else if (vO2Max >= 23.6 && vO2Max < 29)
                    return "Poor"
                else if (vO2Max >= 29 && vO2Max < 33)
                    return "Fair"
                else if (vO2Max >= 33 && vO2Max < 37)
                    return "Good"
                else if (vO2Max >= 37 && vO2Max < 41)
                    return "Excellent"
                else
                    return "Superior"
            }
            if (this.age >= 30 && this.age < 40) {
                if (vO2Max < 22.8)
                    return "Very Poor"
                else if (vO2Max >= 22.8 && vO2Max < 27)
                    return "Poor"
                else if (vO2Max >= 27 && vO2Max < 31.5)
                    return "Fair"
                else if (vO2Max >= 31.5 && vO2Max < 35.7)
                    return "Good"
                else if (vO2Max >= 35.7 && vO2Max < 40.1)
                    return "Excellent"
                else
                    return "Superior"
            }
            if (this.age >= 40 && this.age < 50) {
                if (vO2Max < 21.0)
                    return "Very Poor"
                else if (vO2Max >= 21.0 && vO2Max < 24.5)
                    return "Poor"
                else if (vO2Max >= 24.5 && vO2Max < 29)
                    return "Fair"
                else if (vO2Max >= 29.0 && vO2Max < 32.9)
                    return "Good"
                else if (vO2Max >= 32.9 && vO2Max < 37)
                    return "Excellent"
                else
                    return "Superior"
            }
        }
        if (this.gender.equals("Female")) {
            if (this.age > 13 && this.age < 19) {
                if (vO2Max < 35.0)
                    return "Very Poor"
                else if (vO2Max >= 35.0 && vO2Max < 38.4)
                    return "Poor"
                else if (vO2Max >= 38.4 && vO2Max < 45.2)
                    return "Fair"
                else if (vO2Max >= 45.2 && vO2Max < 51)
                    return "Good"
                else if (vO2Max >= 51.0 && vO2Max < 56)
                    return "Excellent"
                else
                    return "Superior"
            }
            if (this.age >= 20 && this.age < 30) {
                if (vO2Max < 33.0)
                    return "Very Poor"
                else if (vO2Max >= 33.0 && vO2Max < 36.5)
                    return "Poor"
                else if (vO2Max >= 36.5 && vO2Max < 42.5)
                    return "Fair"
                else if (vO2Max >= 42.5 && vO2Max < 46.5)
                    return "Good"
                else if (vO2Max >= 46.5 && vO2Max < 52.5)
                    return "Excellent"
                else
                    return "Superior"
            }
            if (this.age >= 30 && this.age < 40) {
                if (vO2Max < 31.5)
                    return "Very Poor"
                else if (vO2Max >= 31.5 && vO2Max < 35.5)
                    return "Poor"
                else if (vO2Max >= 35.5 && vO2Max < 41)
                    return "Fair"
                else if (vO2Max >= 41.0 && vO2Max < 45)
                    return "Good"
                else if (vO2Max >= 45 && vO2Max < 49.5)
                    return "Excellent"
                else
                    return "Superior"
            }
            if (this.age >= 40 && this.age < 50) {
                if (vO2Max < 30.2)
                    return "Very Poor"
                else if (vO2Max >= 30.2 && vO2Max < 33.6)
                    return "Poor"
                else if (vO2Max >= 33.6 && vO2Max < 39)
                    return "Fair"
                else if (vO2Max >= 39.0 && vO2Max < 43.8)
                    return "Good"
                else if (vO2Max >= 43.8 && vO2Max < 48.1)
                    return "Excellent"
                else
                    return "Superior"
            }
        }
        return "Not enough variables"
    }

}
