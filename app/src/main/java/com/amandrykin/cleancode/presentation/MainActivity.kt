package com.amandrykin.cleancode.presentation

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.amandrykin.cleancode.R
import com.amandrykin.cleancode.app.App
import com.amandrykin.cleancode.data.repository.UserRepositoryImpl
import com.amandrykin.cleancode.data.storage.sharedprefs.SharedPrefUserStorage
import com.amandrykin.cleancode.domain.models.SaveUserNameParam
import com.amandrykin.cleancode.domain.models.UserName
import com.amandrykin.cleancode.domain.usecase.GetUserNameUseCase
import com.amandrykin.cleancode.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject

// data, domain скопированы в отдельные модули

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "Activity created")

        vm = ViewModelProvider(this, vmFactory)
            .get(MainViewModel::class.java)

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