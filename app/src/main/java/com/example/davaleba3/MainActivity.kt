package com.example.davaleba3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.davaleba3.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSave.setOnClickListener {

            checkAllFields()

            when {

                !binding.eMail.text.toString().contains('@') && !binding.eMail.text.toString()
                    .contains('.') -> invalidEmail()
                binding.userName.text.toString().count() < 10 -> lessThan10()
                else -> Toast.makeText(this, getString(R.string.thankYou), Toast.LENGTH_LONG).show()
            }

        }

        binding.btnClear.setOnLongClickListener {
            clearAllFields()
            true
        }

    }


    private fun lessThan10() {
        Toast.makeText(this, getString(R.string.usernameLessThan10), Toast.LENGTH_LONG).show()
    }

    private fun invalidEmail() {
        Toast.makeText(this, getString(R.string.invalidEmail), Toast.LENGTH_LONG).show()
    }

    private fun checkAllFields() {
        if (binding.age.text.isNullOrBlank()) {
            Toast.makeText(this, getString(R.string.checkFields), Toast.LENGTH_LONG).show()
        } else return

    }

    private fun clearAllFields() {
        binding.eMail.text?.clear()
        binding.userName.text?.clear()
        binding.firstName.text?.clear()
        binding.lastName.text?.clear()
        binding.age.text?.clear()

    }


}
