package com.example.sharedpreference

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("Note",MODE_PRIVATE)


        binding.saveBtn.setOnClickListener {
            val note = binding.editText.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("note", note)
            editor.apply()

            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
            binding.editText.text.clear()


        }
        binding.button.setOnClickListener {
            val note = sharedPreferences.getString("note", "null")
            binding.TV.text = note
        }

    }
}



