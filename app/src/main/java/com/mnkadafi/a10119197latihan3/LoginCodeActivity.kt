package com.mnkadafi.a10119197latihan3

//<!--27 April 2022-->
//<!--10119197-->
//<!--Mochamad Nurkhayal Kadafi-->
//<!--IF-5-->

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.text.HtmlCompat
import com.mnkadafi.a10119197latihan3.databinding.ActivityLoginCodeBinding
import kotlinx.android.synthetic.main.activity_warning_dialog.view.*

class LoginCodeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginCodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        covertTagHTMLString()
        intentToBio()
    }

    private fun covertTagHTMLString() {
        binding.apply {
            val htmlText = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(
                    getString(R.string.check_code_text_agreement),
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            } else {
                @Suppress("DEPRECATION")
                Html.fromHtml(getString(R.string.check_code_text_agreement))
            }

            txtCheckCodeAgree.text = htmlText
        }
    }

    private fun intentToBio() {
        binding.apply {
            btnCheckCode.setOnClickListener {
                val inputCode = edtInputCode.text.toString()

                if (inputCode == "") {
                    showWarningDialog()
                } else {
                    startActivity(Intent(this@LoginCodeActivity, BiodataActivity::class.java))
                }
            }
        }
    }

    private fun showWarningDialog() {
        val viewWarningDialog = View.inflate(this@LoginCodeActivity, R.layout.activity_warning_dialog, null)
        val builder = AlertDialog.Builder(this@LoginCodeActivity)
        builder.setView(viewWarningDialog)

        val dialog = builder.create()

        viewWarningDialog.txtWarningDialogTitle.text = getString(R.string.check_code_warning_empty_title)
        viewWarningDialog.txtWarningDialogDesc.text = getString(R.string.check_code_warning_empty_desc)

        dialog.setCancelable(false)
        dialog.show()

        viewWarningDialog.btnWarningDialogOk.setOnClickListener { dialog.dismiss() }
    }
}