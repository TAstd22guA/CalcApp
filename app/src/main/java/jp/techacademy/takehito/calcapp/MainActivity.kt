package jp.techacademy.takehito.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import jp.techacademy.takehito.calcapp.databinding.ActivityMainBinding // 追加


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // View BindingでUI部品を指定
        binding.button1.text = "足し算"
        binding.button2.text = "引き算"
        binding.button3.text = "掛け算"
        binding.button4.text = "割り算"

        binding.button1.setOnClickListener(this) //足し算
        binding.button2.setOnClickListener(this) //引き算
        binding.button3.setOnClickListener(this) //掛け算
        binding.button4.setOnClickListener(this) //割り算
    }

    override fun onClick(v: View) {

        //エラー（強制終了）
        //val num1 = binding.editText1.text.toString().toFloat()
        //val num2 = binding.editText2.text.toString().toFloat()
        //if(num1.equals("")){}


        //editText1とeditText2に数値が入力されているかのチェックとメッセージ表示
        if (binding.editText1.text.toString() == "" && binding.editText2.text.toString() == "") {
            Snackbar.make(v, "入力値が未入力です", Snackbar.LENGTH_INDEFINITE).show()
        } else if (binding.editText1.text.toString() == "") {
            Snackbar.make(v, "入力値1が未入力です", Snackbar.LENGTH_INDEFINITE).show()
        } else if (binding.editText2.text.toString() == "") {
            Snackbar.make(v, "入力値2が未入力です", Snackbar.LENGTH_INDEFINITE).show()
        } else {
            val num1 = binding.editText1.text.toString().toFloat()
            val num2 = binding.editText2.text.toString().toFloat()
            val intent = Intent(this, SecondActivity::class.java)

            //四則演算の各ボタンの処理
            when (v.id) {
                R.id.button1 -> {
                    var num3 = num1 + num2
                    intent.putExtra("VALUE", num3)
                }
                R.id.button2 -> {
                    var num3 = num1.minus(num2)
                    intent.putExtra("VALUE", num3)
                }
                R.id.button3 -> {
                    val num3 = num1 * num2
                    intent.putExtra("VALUE", num3)
                }
                R.id.button4 -> {
                    val num3 = num1 / num2
                    intent.putExtra("VALUE", num3)
                }
            }
            startActivity(intent)
        }
    }
}
