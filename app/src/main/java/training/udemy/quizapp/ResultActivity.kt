package training.udemy.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity()
{

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_result)
    intent?.extras?.let {
      val name = it[Constants.NAME]
      val score = it[Constants.SCORE]
      val total = it[Constants.TOTAL]
      tv_result.text = "Congrats $name, your score is : $score / $total"
    }

    btn_finish.setOnClickListener {
      startActivity(Intent(this, MainActivity::class.java))
      finish()
    }

  }
}
