package kg.less.hm_04_05m

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import kg.less.hm_04_05m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[CounterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReset.setOnClickListener {
            viewModel.resetCounter()
        }

        binding.btnIncrement.setOnClickListener {
            viewModel.incrementCounter()
        }
        binding.btnDecrement.setOnClickListener {
            viewModel.decrementCounter()
        }

        viewModel.counterData.observe(this) {
            when (it) {
                10 -> Toast.makeText(this@MainActivity, "Сongratulations", Toast.LENGTH_SHORT).show()
                15 -> binding.tvCount.setTextColor(Color.GREEN)
                0 -> binding.tvCount.setTextColor(Color.BLACK)
            }
            binding.tvCount.text = it.toString()
        }
    }
}