package mobile.example.tugas2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen UI
        val temperatureInput = findViewById<EditText>(R.id.temperatureInput)
        val celsiusToFahrenheit = findViewById<RadioButton>(R.id.celsiusToFahrenheit)
        val fahrenheitToCelsius = findViewById<RadioButton>(R.id.fahrenheitToCelsius)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        // Set listener onClick untuk tombol
        convertButton.setOnClickListener {
            // Ambil nilai input
            val temperature = temperatureInput.text.toString().toDoubleOrNull()

            // Lakukan konversi jika input valid
            if (temperature != null) {
                val result: Double
                val resultUnit: String

                if (celsiusToFahrenheit.isChecked) {
                    // Konversi Celsius ke Fahrenheit
                    result = (temperature * 9 / 5) + 32
                    resultUnit = "°F"
                } else {
                    // Konversi Fahrenheit ke Celsius
                    result = (temperature - 32) * 5 / 9
                    resultUnit = "°C"
                }

                // Tampilkan hasil
                resultText.text = "Hasil: $result $resultUnit"
            } else {
                resultText.text = "Input tidak valid. Harap masukkan angka yang benar."
            }
        }
    }
}