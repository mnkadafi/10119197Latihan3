package com.mnkadafi.a10119197latihan3

//<!--27 April 2022-->
//<!--10119197-->
//<!--Mochamad Nurkhayal Kadafi-->
//<!--IF-5-->

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mnkadafi.a10119197latihan3.databinding.ActivityWelcomeBinding
import com.penatabahasa.latihan3.IntentID.ID_EXTRA_MSG_EXIT

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intentMoveToLoginCode()
        allActivityFinish()
    }

    private fun allActivityFinish() {
        if (intent.getBooleanExtra(ID_EXTRA_MSG_EXIT, false)) {
            finish()
        }
    }

    private fun intentMoveToLoginCode() {
        binding.apply {
            btnWalkthroughStart.setOnClickListener {
                val intent = Intent(this@WelcomeActivity, LoginCodeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}