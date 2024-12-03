package com.example.first_project

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class UserInteraction : AppCompatActivity() {

    lateinit var toastBtn: Button
    lateinit var snackBtn: Button
    lateinit var alertBtn: Button
    lateinit var main:ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interaction)

        toastBtn = findViewById(R.id.toastBtn)
        snackBtn = findViewById(R.id.snackBtn)
        alertBtn = findViewById(R.id.alertBtn)
        main = findViewById(R.id.main)


        toastBtn.setOnClickListener({
          Toast.makeText(this@UserInteraction,
              "Invalid Login",
              Toast.LENGTH_LONG)
              .show()
        })

        snackBtn.setOnClickListener({

            Snackbar.make(main,
                "no internet connec cion",
                Snackbar.LENGTH_LONG).setAction("Retry",{}).show()



        })


        alertBtn.setOnClickListener({
            val alert = AlertDialog.Builder(this@UserInteraction)

            alert.setTitle("Confirm")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                .setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })


            alert.create().show()


        })












        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}