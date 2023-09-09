package uri.pdm.atividade_4_viagem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val username = findViewById<EditText>(R.id.userNameField)

        loginButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SelectTravelActivity::class.java)
            intent.putExtra("username", username.text.toString())
            startActivity(intent)
        }
    }
}