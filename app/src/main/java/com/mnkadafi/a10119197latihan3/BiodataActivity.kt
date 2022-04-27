package com.mnkadafi.a10119197latihan3

//<!--27 April 2022-->
//<!--10119197-->
//<!--Mochamad Nurkhayal Kadafi-->
//<!--IF-5-->

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.mnkadafi.a10119197latihan3.databinding.ActivityBiodataBinding
import com.penatabahasa.latihan3.IntentID
import kotlinx.android.synthetic.main.activity_warning_dialog.view.*

class BiodataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBiodataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBiodataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intentMoveToDone()
    }

    private fun intentMoveToDone() {
        binding.apply {
            btnBiodataNext.setOnClickListener {
                val dataName = edtBiodataName.text.toString()
                val dataAge = edtBiodataAge.text.toString()

                if (dataAge.isEmpty()) {
                    Toast.makeText(
                        this@BiodataActivity,
                        R.string.age_empty,
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val age = dataAge.toInt()
                    val user = Person(dataName, age)

                    if (dataName == "") {
                        showWarningDialog()
                    } else {
                        val intent = Intent(this@BiodataActivity, DoneActivity::class.java)
                        intent.putExtra(IntentID.ID_EXTRA_MSG, user)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun showWarningDialog() {
        val view = View.inflate(this@BiodataActivity, R.layout.activity_warning_dialog, null)
        val builder = AlertDialog.Builder(this@BiodataActivity)
        builder.setView(view)
        val dialog = builder.create()

        view.txtWarningDialogTitle.text = getString(R.string.check_code_warning_empty_title_name)
        view.txtWarningDialogDesc.text = getString(R.string.check_code_warning_empty_desc_name)

        dialog.setCancelable(false)
        dialog.show()

        view.btnWarningDialogOk.setOnClickListener { dialog.dismiss() }
    }
}