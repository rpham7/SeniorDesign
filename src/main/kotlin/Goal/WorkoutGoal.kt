package Goal

import User

abstract class WorkoutGoal {
    abstract var goal: String
    var userList = listOf<User>()

    constructor(listUser: List<User>) {
        userList = listUser
    }

    fun addUser(person: User){
        userList += person
    }

    abstract fun showList()
}