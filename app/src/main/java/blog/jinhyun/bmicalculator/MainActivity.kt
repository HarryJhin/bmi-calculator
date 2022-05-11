package blog.jinhyun.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import blog.jinhyun.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    /**
     * 뷰바인딩 객체 얻기
     */
    private val binding by lazy {
        // `ActivityMainBinding` 클래스는 `activity_main.xml`의 이름을 참고하여 뷰바인딩 설정에 의해 자동 생성
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // `R.layout.activity_main` 같은 효과, `activity_main`을 참고
        setContentView(binding.root)

        // `ResultActivity`로 이동
        binding.resultButton.setOnClickListener {
            // 결과 버튼이 클릭되면 할 일
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }
    }
}