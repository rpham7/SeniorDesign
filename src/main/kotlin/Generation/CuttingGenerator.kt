package Generation

import Goal.Cutting
import Goal.Maintaining
import SQLExtraction
import User
import java.lang.Math.abs

class CuttingGenerator {
    var cutting: Cutting
    var workouts: List<Map<String, String>>
    var user:User
    val nutrients:String = "Reminder to consume less carbohydrates when Cutting!"

    constructor(cutting: Cutting, user:User) {
        val temp = SQLExtraction("root", "7230")
        this.cutting = cutting
        this.workouts = temp.extractWorkouts()
        this.user = user
    }

    fun generate() {
        var temp: List<User> = cutting.userList
        val fitLevel = user.getfitLevel()
        val userVO2 = user.VO2Max()
        var listComparison: MutableList<User> = mutableListOf()

        println(nutrients)

        //sets til failure
        for(userTemp in temp) {
            if(abs(user.getBodyFat() - userTemp.getBodyFat()) <= 1) {
                if (abs(user.getHeight() - userTemp.getHeight()) <= 5) {
                    if (abs(user.getWeight() - userTemp.getWeight()) <= 10) {
                        listComparison.add(userTemp)
                    }
                }
            }

        }
        var listOfWorkouts: MutableList<Map<String, String>> = mutableListOf()

        for(userTempShortenList in listComparison) {
            if(listOfWorkouts.isEmpty())
                listOfWorkouts = userTempShortenList.getWorkout()
            else {
                for (workouts in userTempShortenList.getWorkout())
                    listOfWorkouts.add(workouts)
            }
        }

        var workoutRoutine: MutableList<Map<String, String>> = mutableListOf()

        //slow start
        if(userVO2.equals("Very Poor")) {
            //pick 2-3 workouts per session
            //pick the simpler workouts

        }
        //slow start
        else if (userVO2.equals("Poor")) {
            // pick 3 workouts per session
        }
        //average start
        else if (userVO2.equals("Fair")) {
            // 3-4 workouts
        }
        // 4days of workout
        else if (userVO2.equals("Good")) {
            // pick 3-4 workouts per session
        }
        // 5 days of workout
        else if (userVO2.equals("Excellent")) {
            //3-4
        }
        // 3 days on 1 day off
        else {
            //3-4

        }

        user.setWorkout(workoutRoutine)
    }
}