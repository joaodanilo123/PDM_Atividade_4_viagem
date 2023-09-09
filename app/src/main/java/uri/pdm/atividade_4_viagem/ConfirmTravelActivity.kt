package uri.pdm.atividade_4_viagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ConfirmTravelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_travel)

        findViewById<TextView>(R.id.destinyValue).text = intent.getStringExtra("destiny")
        findViewById<TextView>(R.id.exitValue).text = intent.getStringExtra("exit")
        findViewById<TextView>(R.id.expenseValue).text = intent.getIntExtra("expense", 0).toString()
        findViewById<TextView>(R.id.travelTypeValue).text = intent.getStringExtra("travelType")
        findViewById<ImageView>(R.id.travelTypeImageValue).setImageResource(intent.getIntExtra("travelTypeId", R.drawable.relax_trip))
    }
}