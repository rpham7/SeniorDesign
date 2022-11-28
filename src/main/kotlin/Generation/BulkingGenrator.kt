package Generation

import Goal.Bulking
import Goal.Maintaining
import SQLExtraction
import User

class BulkingGenrator {
    var bulking: Bulking
    var workouts: List<Map<String, String>>
    var user:User
    val nutrients:String = "Reminder to consume more calories when Bulking!"

    constructor(bulking:Bulking, user: User) {
        val temp: SQLExtraction = SQLExtraction("root", "7230")
        this.bulking = bulking
        this.workouts = temp.extractWorkouts()
        this.user = user
    }
    fun generate(): Map<String, String> {
        var temp: List<User> = bulking.userList
        println(nutrients)

        //sets til failure
        for(user in temp) {

        }
        return mapOf()
    }
}
