package Goal

import User

class Maintaining(listUser: List<User>): WorkoutGoal(listUser) {
    override var goal:String = "maintaining"

    override fun showList() {
        for (items in userList)
            println(items.getfitLevel())
    }
}