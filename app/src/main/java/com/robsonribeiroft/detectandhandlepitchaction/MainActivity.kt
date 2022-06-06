package com.robsonribeiroft.detectandhandlepitchaction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.robsonribeiroft.detectandhandlepitchaction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = MyAdapter()
    private var numberOfColumn = NUMBER_COLUMNS_BY_ROW

    companion object {
        private const val NUMBER_COLUMNS_BY_ROW = 8
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.customList.layoutManager = PinchDetectLayoutManager(this, NUMBER_COLUMNS_BY_ROW)
        binding.customList.adapter = adapter
        adapter.items = PicturesModel.fakeList()

    }

    override fun onResume() {
        super.onResume()

    }
}