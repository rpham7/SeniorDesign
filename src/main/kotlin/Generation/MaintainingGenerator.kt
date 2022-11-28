package Generation

import Goal.Maintaining
import SQLExtraction
import User

// use userList: List<User> can work too
class MaintainingGenerator {
    var maintaining: Maintaining
    var workouts: List<Map<String, String>>
    var user: User
    val nutrients:String = "Reminder to maintain a well balanced diet!"

    constructor(maintaining: Maintaining, user:User) {
        val temp: SQLExtraction = SQLExtraction("root", "7230")
        this.maintaining = maintaining
        this.workouts = temp.extractWorkouts()
        this.user = user
    }

    fun generate(): Map<String, String> {
        var temp: List<User> = maintaining.userList
        println(nutrients)

        //sets til failure
        for(user in temp) {

        }
        return mapOf()
    }
}