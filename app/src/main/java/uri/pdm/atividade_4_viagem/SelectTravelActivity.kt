package uri.pdm.atividade_4_viagem


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SelectTravelActivity : AppCompatActivity() {

    private var travelType : String = ""
    private var travelTypeImage : Int = 0
    private var expense : Int = 0
    private var destiny: String = ""
    private var exit: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecionar_viagem)

        val greetingText = findViewById<TextView>(R.id.greetingsText)
        val username = intent.getStringExtra("username")

        greetingText.text = "Olá ${username}"

        val tripTypeImage = findViewById<ImageView>(R.id.tripTypeImage)
        val tripTypeRGroup = findViewById<RadioGroup>(R.id.tripTypeRadioGroup)
        val expenseSelector = findViewById<SeekBar>(R.id.expenseSelector)
        val selectedExpense = findViewById<TextView>(R.id.selectedExpense)
        val destinyEdit = findViewById<EditText>(R.id.destinyField)
        val exitEdit = findViewById<EditText>(R.id.exitField)


        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            destiny = destinyEdit.text.toString()
            exit = exitEdit.text.toString()

            if(travelType.isEmpty()
                || destiny.isEmpty()
                || exit.isEmpty()
                || travelTypeImage == 0
                || expense == 0) {
                Toast.makeText(this, "Nem todos os campos Foram Preenchidos", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ConfirmTravelActivity::class.java)
                intent.putExtra("destiny", destiny)
                intent.putExtra("exit", exit)
                intent.putExtra("travelTypeId", travelTypeImage)
                intent.putExtra("travelType", travelType)
                intent.putExtra("expense", expense)
                startActivity(intent)
                finish()
            }
        }

        expenseSelector.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                selectedExpense.text = "R$ ${expenseSelector.progress}"
                expense = expenseSelector.progress
            }
        })

        tripTypeRGroup.setOnCheckedChangeListener { _ , i ->
            tripTypeImage.setImageResource(this.setTripTypeHandler(i))
        }

    }

    private fun setTripTypeHandler(tripTypeRadioId : Int) : Int {

        var imageId : Int = 0

        fun adjustImageAndReturnValue(drawableId : Int, value: String) {
            this.travelTypeImage = drawableId
            this.travelType = value
            imageId = drawableId
        }

        when(tripTypeRadioId) {
            R.id.radio_adventure -> adjustImageAndReturnValue(R.drawable.adventure_trip, "Aventura")
            R.id.radio_business -> adjustImageAndReturnValue(R.drawable.business_trip, "Negócio")
            R.id.radio_relax -> adjustImageAndReturnValue(R.drawable.relax_trip, "Turismo Relax")
            R.id.radio_culture -> adjustImageAndReturnValue(R.drawable.cultural_trip, "Turismo Cultural")
        }

        return imageId

    }
}