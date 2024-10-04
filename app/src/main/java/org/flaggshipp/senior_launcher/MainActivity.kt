// This Code is under copyright of Flaggshipp. If you want to change something and modify this App you need to send me an email and tell what you modified.
// You can freely change the App Names and publish the changes.

package org.flaggshipp.senior_launcher

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_SeniorLauncher)
        setContentView(R.layout.activity_main)

        val calc : GridLayout = findViewById(R.id.calc)
        val camera : GridLayout = findViewById(R.id.camera)
        val contacts : GridLayout = findViewById(R.id.contacts)
        val clock : GridLayout = findViewById(R.id.clock)
        val google : GridLayout = findViewById(R.id.google)
        val photos : GridLayout = findViewById(R.id.photos)
        val settings : GridLayout = findViewById(R.id.settings)
        val whatsapp : GridLayout = findViewById(R.id.whatsapp)
        val telephone : GridLayout = findViewById(R.id.telephone)
        val email : GridLayout = findViewById(R.id.email)
        val sms : GridLayout = findViewById(R.id.sms)
        val calendar : GridLayout = findViewById(R.id.calender)
        val maps : GridLayout = findViewById(R.id.maps)

        email.setOnClickListener (View.OnClickListener {
            openApp("Gmail")
        })

        sms.setOnClickListener (View.OnClickListener {
            openApp("Messages")
        })

        calendar.setOnClickListener (View.OnClickListener {
            openApp("Kalender")
        })

        maps.setOnClickListener (View.OnClickListener {
            openApp("Maps")
        })

        calc.setOnClickListener (View.OnClickListener {
            openApp("Rechner")
        })

        camera.setOnClickListener (View.OnClickListener {
            openApp("Kamera")
        })

        contacts.setOnClickListener (View.OnClickListener {
            openApp("Kontakte")
        })

        clock.setOnClickListener (View.OnClickListener {
            openApp("Uhr")
        })

        google.setOnClickListener (View.OnClickListener {
            openApp("Google")
        })

        photos.setOnClickListener (View.OnClickListener {
            openApp("Fotos")
        })

        settings.setOnClickListener (View.OnClickListener {
            openApp("Einstellungen")
        })

        whatsapp.setOnClickListener (View.OnClickListener {
            openApp("WhatsApp")
        })

        telephone.setOnClickListener (View.OnClickListener {
            openApp("Telefon")
        })

    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openApp(appName: String) {
        val packageManager = packageManager
        val apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA)

        var found = false

        for (app in apps) {
            val label = packageManager.getApplicationLabel(app).toString()

            if (label.equals(appName, ignoreCase = true)) {
                found = true
                val intent = packageManager.getLaunchIntentForPackage(app.packageName)
                if (intent != null) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    return
                }
            }
        }

        if (!found) {
            Toast.makeText(this, "App '$appName' couldnt be found", Toast.LENGTH_LONG).show()
        }
    }

}