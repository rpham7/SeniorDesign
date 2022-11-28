package Goal

import User

class Cutting(listUser: List<User>): WorkoutGoal(listUser) {
    override var goal:String = "cutting"

    override fun showList() {
        for (items in userList)
            println(items.getfitLevel())
    }
}