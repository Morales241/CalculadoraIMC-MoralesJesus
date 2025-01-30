package morales.jesus.asignacion4_calculadoraimc_morales

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import morales.jesus.asignacion4_calculadoraimc_morales.R.color.colorRed

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val altura: EditText = findViewById(R.id.estatura) as EditText
        val peso: EditText = findViewById(R.id.kilos) as EditText
        val btnCalcular: Button = findViewById(R.id.btnCalcular) as Button
        val IMC: TextView = findViewById(R.id.IMC) as TextView
        val resultado: TextView = findViewById(R.id.resultado) as TextView

        btnCalcular.setOnClickListener {

            var alturaAux = altura.text.toString().toDoubleOrNull()
            var pesoAux = peso.text.toString().toDoubleOrNull()

            if (alturaAux != null && pesoAux != null && alturaAux > 0) {
                val imc = pesoAux / (alturaAux * alturaAux)

                IMC.text = String.format("Tu IMC es: %.2f", imc)

                when {
                    imc < 18.5 -> {
                        resultado.text = "Bajo peso"
                        resultado.setBackgroundResource(R.color.colorYellow)
                    }

                    (imc >= 18.5 && imc < 25) -> {
                        resultado.text = "Normal"
                        resultado.setBackgroundResource(R.color.colorGreen)
                    }

                    (imc >= 25.0 && imc < 30) -> {
                        resultado.text = "Sobrepeso"
                        resultado.setBackgroundResource(R.color.colorYellow)
                    }
                    (imc >= 30.0 && imc < 35) -> {
                        resultado.text = "Obesidad grado 1"
                        resultado.setBackgroundResource(R.color.colorOrange)
                    }
                    (imc >= 35.0 && imc < 40) -> {
                        resultado.text = "Obesidad grado 2"
                        resultado.setBackgroundResource(R.color.colorRed)
                    }
                    else -> {
                        resultado.text = "Obesidad grado 3"
                        resultado.setBackgroundResource(R.color.colorBrown)
                    }
                }
            } else {
                IMC.text =""
                resultado.text = "ingrese valores validos"
                resultado.setBackgroundResource(colorRed)
            }

        }
    }


}