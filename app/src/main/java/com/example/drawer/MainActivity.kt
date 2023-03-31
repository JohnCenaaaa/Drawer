package com.example.drawer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.drawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.button.setOnClickListener{
            addNickname(it)}
        binding.button.setOnClickListener{
            updateNickName(it)}
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener{
        addNickname(it)}

        findViewById<TextView>(R.id.nickname_test).setOnClickListener{
        updateNickName(it)}
    }
    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_test)

        binding.nicknameTest.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.VISIBLE

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun updateNickName(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val button = findViewById<Button>(R.id.button)

        editText.visibility = View.VISIBLE
        button.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()
    }
}