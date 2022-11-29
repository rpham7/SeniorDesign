package Generation

import Goal.Bulking
import SQLExtraction
import User
import java.lang.Math.abs

class BulkingGenerator {
    var Bulking: Bulking
    var workouts: Map<String, String>
    var user:User
    val nutrients:String = "Reminder to consume more calories than normal!"

    constructor(Bulking: Bulking, user:User) {
        val temp = SQLExtraction("root", "7230")
        this.Bulking = Bulking
        this.workouts = temp.extractWorkouts()
        this.user = user
    }

    fun generate() {
        var temp: List<User> = Bulking.userList
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
        var listOfWorkouts: MutableMap<String, String> = mutableMapOf()

        for(userTempShortenList in listComparison) {
            if(listOfWorkouts.isEmpty())
                listOfWorkouts = userTempShortenList.getWorkout()
            else {
                for (workouts in userTempShortenList.getWorkout())
                    listOfWorkouts.put(workouts.key, workouts.value)
            }
        }

        var workoutRoutine: MutableMap<String, String> = mutableMapOf()

        //slow start
        if(userVO2.equals("Very Poor")) {
            //pick 2-3 workouts per session
            //pick the simpler workouts
            for (workouts in listOfWorkouts) {
                if(workouts.key.endsWith("1") or workouts.key.endsWith("2") or workouts.key.endsWith("3"))
                    workoutRoutine.put(workouts.key, workouts.value)
            }
        }
        //slow start
        else if (userVO2.equals("Poor")) {
            // pick 3 workouts per session
            for (workouts in listOfWorkouts) {
                if(workouts.key.endsWith("1") or workouts.key.endsWith("2") or workouts.key.endsWith("3"))
                    workoutRoutine.put(workouts.key, workouts.value)
            }
        }
        //average start
        else if (userVO2.equals("Fair")) {
            // 3-4 workouts
            for (workouts in listOfWorkouts) {
                if(workouts.key.endsWith("1") or workouts.key.endsWith("2") or workouts.key.endsWith("3") or workouts.key.endsWith("4"))
                    workoutRoutine.put(workouts.key, workouts.value)
            }
        }
        // 4days of workout
        else if (userVO2.equals("Good")) {
            // pick 3-4 workouts per session
            for (workouts in listOfWorkouts) {
                if(workouts.key.endsWith("1") or workouts.key.endsWith("2") or workouts.key.endsWith("3") or workouts.key.endsWith("4"))
                    workoutRoutine.put(workouts.key, workouts.value)
            }
        }
        // 5 days of workout
        else if (userVO2.equals("Excellent")) {
            //3-4
            for (workouts in listOfWorkouts) {
                if(workouts.key.endsWith("1") or workouts.key.endsWith("2") or workouts.key.endsWith("3") or workouts.key.endsWith("4"))
                    workoutRoutine.put(workouts.key, workouts.value)
            }
        }
        // 3 days on 1 day off
        else {
            //3-4
            for (workouts in listOfWorkouts) {
                if(workouts.key.endsWith("1") or workouts.key.endsWith("2") or workouts.key.endsWith("3") or workouts.key.endsWith("4"))
                    workoutRoutine.put(workouts.key, workouts.value)
            }

        }

        user.setWorkout(workoutRoutine)
    }
}