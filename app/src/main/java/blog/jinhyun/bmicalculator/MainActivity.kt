package blog.jinhyun.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
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

        // 액티비티를 시작하면 저장된 값 불러오기, `data/data/패키지명/shared_prefs`에 있음
        loadData()

        // `ResultActivity`로 이동
        binding.resultButton.setOnClickListener {
            // 결과 버튼이 클릭되면 할 일
            if (binding.weightEditText.text.isNotBlank() && binding.heightEditText.text.isNotBlank()) {
                // 마지막에 입력한 키, 몸무게 값 저장
                saveData(
                    binding.heightEditText.text.toString().toFloat(),
                    binding.weightEditText.text.toString().toFloat(),
                )

                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("weight", binding.weightEditText.text.toString().toFloat())
                    putExtra("height", binding.heightEditText.text.toString().toFloat())
                }
                startActivity(intent)
            }
        }
    }

    // 데이터를 저장하는 함수
    private fun saveData(height: Float, weight: Float) {
        // 프리퍼런스 객체 얻기
        val preference = PreferenceManager.getDefaultSharedPreferences(this)
        // 프리퍼런스 객체의 에디터 얻기
        val editor = preference.edit()
        // 인수로 전달받은 height, weight 반영
        editor.putFloat("KEY_HEIGHT", height).putFloat("KEY_WEIGHT", weight).apply()
    }

    // 저장된 값을 불러오는 함수
    private fun loadData() {
        val preference = PreferenceManager.getDefaultSharedPreferences(this)
        val height = preference.getFloat("KEY_HEIGHT", 0f)
        val weight = preference.getFloat("KEY_WEIGHT", 0f)

        if (height != 0f && weight != 0f) {
            binding.heightEditText.setText(height.toString())
            binding.weightEditText.setText(weight.toString())
        }
    }
}
