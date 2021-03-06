package blog.jinhyun.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import blog.jinhyun.bmicalculator.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityResultBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val weight = intent.getFloatExtra("weight", 0f)
        val height = intent.getFloatExtra("height", 0f)

        // bmi 계산
        val bmi = weight / (height / 100.0f).pow(2.0f)

        // 텍스트 변경
        when {
            bmi >= 35 -> binding.resultTextView.text = "고도 비만"
            bmi >= 30 -> binding.resultTextView.text = "2단계 비만"
            bmi >= 25 -> binding.resultTextView.text = "1단계 비만"
            bmi >= 23 -> binding.resultTextView.text = "과체중"
            bmi >= 18.5 -> binding.resultTextView.text = "정상"
            else -> binding.resultTextView.text = "저체중"
        }

        // 이미지 변경
        when {
            bmi >= 23 -> binding.imageView.setImageResource(R.drawable.ic_baseline_sentiment_very_dissatisfied_24)
            bmi >= 18.5 -> binding.imageView.setImageResource(R.drawable.ic_baseline_sentiment_satisfied_alt_24)
            else -> binding.imageView.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
        }
        
        // 토스트 메시지 출력
        Toast.makeText(this, "$bmi", Toast.LENGTH_SHORT).show()
    }
}