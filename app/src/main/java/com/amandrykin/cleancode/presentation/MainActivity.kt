package com.amandrykin.cleancode.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.amandrykin.cleancode.R
import org.koin.androidx.viewmodel.ext.android.viewModel

// data, domain скопированы в отдельные модули

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val recieveButton = findViewById<Button>(R.id.recieveButton)

        // здесь идет подписка на изменение данных
        //1-й способ обращения через метод get
//        vm.getResultLive().observe(this, { text ->
//            dataTextView.text = text
//        })

        //2-й способ обращения через переменную resultLive: LiveData
        vm.resultLive.observe(this, { text ->
            dataTextView.text = text
        })

        sendButton.setOnClickListener {
            // Клик по кнопке Save data
            val text = dataEditView.text.toString()
            vm.save(text)
        }

        recieveButton.setOnClickListener {
            // Клик по кнопке Get data
            vm.load()
        }
    }
}