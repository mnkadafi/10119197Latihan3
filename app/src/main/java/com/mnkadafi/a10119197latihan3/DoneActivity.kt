package com.mnkadafi.a10119197latihan3

//<!--27 April 2022-->
//<!--10119197-->
//<!--Mochamad Nurkhayal Kadafi-->
//<!--IF-5-->

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mnkadafi.a10119197latihan3.databinding.ActivityDoneBinding
import com.penatabahasa.latihan3.IntentID

class DoneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setName()
    }

    @SuppressLint("SetTextI18n")
    private fun setName() {
        binding.apply {
            val dataPerson = intent.getParcelableExtra<Person>(IntentID.ID_EXTRA_MSG)
            val name = "" + dataPerson?.name + ""
            val done = getString(R.string.activation_done)
            val ableTo = getString(R.string.activation_able_to)
            val each = getString(R.string.activation_each)
            val make = getString(R.string.activation_make)

            txtDoneTitle.text = "$done $name $ableTo $name $each $name $make"

            btnDoneNext.setOnClickListener {
                val intent = Intent(this@DoneActivity, WelcomeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                intent.putExtra(IntentID.ID_EXTRA_MSG_EXIT, true)
                startActivity(intent)
            }
        }
    }
}