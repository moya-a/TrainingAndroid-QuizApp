package training.udemy.quizapp

object Constants
{

  const val SCORE = "score"
  const val TOTAL = "total"
  const val NAME = "name"

  fun getQuestions(): ArrayList<Question>
  {
    val qList = ArrayList<Question>()
    qList.add(
      Question(
        1, "What country does this flag belong to?",
        R.drawable.ic_flag_of_argentina,
        arrayListOf<String>(
          "Argentina", "Australia",
          "Armenia", "Austria"
        ), 1
      )
    )
    qList.add(
      Question(
        2, "What country does this flag belong to?",
        R.drawable.ic_flag_of_australia,
        arrayListOf<String>("Angola", "Austria", "Australia", "Armenia"), 3
      )
    )
    qList.add(
      Question(
        3, "What country does this flag belong to?",
        R.drawable.ic_flag_of_brazil,
        arrayListOf<String>(
          "Belarus", "Belize",
          "Brunei", "Brazil"
        ), 4
      )
    )
    qList.add(
      Question(
        4, "What country does this flag belong to?",
        R.drawable.ic_flag_of_belgium,
        arrayListOf<String>(
          "Bahamas", "Belgium",
          "Barbados", "Belize"
        ), 2
      )
    )
    qList.add(
      Question(
        5, "What country does this flag belong to?",
        R.drawable.ic_flag_of_fiji,
        arrayListOf<String>(
          "Gabon", "France",
          "Fiji", "Finland"
        ), 3
      )
    )
    qList.add(
      Question(
        6, "What country does this flag belong to?",
        R.drawable.ic_flag_of_germany,
        arrayListOf<String>(
          "Germany", "Georgia",
          "Greece", "none of these"
        ), 1
      )
    )
    qList.add(
      Question(
        7, "What country does this flag belong to?",
        R.drawable.ic_flag_of_denmark,
        arrayListOf<String>(
          "Dominica", "Egypt",
          "Denmark", "Ethiopia"
        ), 3
      )
    )
    qList.add(
      Question(
        8, "What country does this flag belong to?",
        R.drawable.ic_flag_of_india,
        arrayListOf<String>(
          "Ireland", "Iran",
          "Hungary", "India"
        ), 4
      )
    )
    qList.add(
      Question(
        9, "What country does this flag belong to?",
        R.drawable.ic_flag_of_new_zealand,
        arrayListOf<String>(
          "Australia", "New Zealand",
          "Tuvalu", "United States of America"
        ), 2
      )
    )
    qList.add(
      Question(
        10, "What country does this flag belong to?",
        R.drawable.ic_flag_of_kuwait,
        arrayListOf<String>(
          "Kuwait", "Jordan",
          "Sudan", "Palestine"
        ), 1
      )
    )
    return qList
  }
}