package Goal

import User

class Bulking(listUser: List<User>) : WorkoutGoal(listUser) {
    override var goal:String = "bulking"

    override fun showList() {
        for (items in userList)
            println(items.getfitLevel())
    }
}
