package training.udemy.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity()
{
  private val questionList: List<Question> by lazy(Constants::getQuestions)

  private var userName: String? = null
  private var questionProgress = 0
  private var selectedQuestion = 0
  private var tvSelected: TextView? = null
  private var tvCorrect: TextView? = null
  private var nbGoodAnswers = 0

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_quiz_questions)
    pb_progress.max = questionList.size
    userName = intent.getStringExtra(Constants.NAME)
    setQuestion()
  }


  fun onSelectAnswer(view: View)
  {
    (view as TextView).let {
      clearSelection()
      tvSelected = it
      it.setBackgroundResource(R.drawable.selected_opt_border)
      when (it.id)
      {
        tv_opt1.id -> selectedQuestion = 1
        tv_opt2.id -> selectedQuestion = 2
        tv_opt3.id -> selectedQuestion = 3
        tv_opt4.id -> selectedQuestion = 4
      }
    }
  }

  @Suppress("UNUSED_PARAMETER")
  private fun onCheckAnswer(view: View)
  {
    if (isAnswerCorrect())
    {
      changeTVColor(tvSelected, isValidAnswer = true)
      nbGoodAnswers++
    }
    else
    {
      changeTVColor(tvSelected, isValidAnswer = false)
      changeTVColor(tvCorrect, isValidAnswer = true)
    }
    if (questionList.size > ++questionProgress)
    {
      bt_submit.text = "Next Question"
      bt_submit.setOnClickListener { onNextQuestion(it) }
    }
    else
    {
      bt_submit.text = "Finish Quiz"
      bt_submit.setOnClickListener { onFinish(it) }
    }
  }


  private fun changeTVColor(
    tv: TextView?,
    isValidAnswer: Boolean = false,
    isDefault: Boolean = false
  )
  {
    tv?.let {
      var bgColor =
        ContextCompat.getDrawable(this, R.drawable.default_opt_border)
      var txtColor = R.color.secondColor
      when
      {
        !isDefault && isValidAnswer  ->
        {
          bgColor = ContextCompat.getDrawable(this, R.color.colorGreen)
          txtColor = R.color.colorBlack
        }
        !isDefault && !isValidAnswer ->
        {
          bgColor = ContextCompat.getDrawable(this, R.color.colorRed)
          txtColor = R.color.colorWhite
        }
      }
      it.background = bgColor
      it.setTextColor(
        ContextCompat.getColor(
          this,
          txtColor
        )
      )
    }
  }

  @Suppress("UNUSED_PARAMETER")
  private fun onNextQuestion(view: View)
  {
    clearSelection()
    setQuestion()
  }

  @Suppress("UNUSED_PARAMETER")
  private fun onFinish(view: View)
  {
    Intent(this, ResultActivity::class.java)
      .run {
        putExtra(Constants.NAME, userName)
        putExtra(Constants.SCORE, nbGoodAnswers)
        putExtra(Constants.TOTAL, questionList.size)
        startActivity(this)
      }
    finish()
  }

  private fun isAnswerCorrect(): Boolean
  {
    return tvSelected!!.id == tvCorrect!!.id
  }

  private fun setQuestion()
  {
    pb_progress.progress = questionProgress + 1
    tv_progress.text = "${questionProgress + 1} / ${questionList.size}"
    questionList[questionProgress]
      .apply {
        tv_question.text = question
        iv_flag.setImageResource(image)
        tv_opt1.text = options[0]
        tv_opt2.text = options[1]
        tv_opt3.text = options[2]
        tv_opt4.text = options[3]
        tvCorrect = when (correctAnswer)
        {
          1    -> tv_opt1
          2    -> tv_opt2
          3    -> tv_opt3
          4    -> tv_opt4
          else -> null // should not happen
        }
      }
    bt_submit.text = "Submit"
    bt_submit.setOnClickListener { onCheckAnswer(it) }
  }

  private fun clearSelection()
  {
    changeTVColor(tv_opt1, isDefault = true)
    changeTVColor(tv_opt2, isDefault = true)
    changeTVColor(tv_opt3, isDefault = true)
    changeTVColor(tv_opt4, isDefault = true)
    selectedQuestion = 0
  }
}
