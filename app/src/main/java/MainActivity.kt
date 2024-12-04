import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: EnderecoViewModel by viewModels()
    private lateinit var cepInput: EditText
    private lateinit var buscarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cepInput = findViewById(R.id.cepInput)
        buscarButton = findViewById(R.id.buscarButton)

        buscarButton.setOnClickListener {
            val cep = cepInput.text.toString()
            if (cep.isNotEmpty()) {
                buscarEndereco(cep)
            } else {
                Toast.makeText(this, "Informe um CEP válido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun buscarEndereco(cep: String) {
        // Chama o ViewModel para buscar o endereço
        viewModel.buscarCep(cep)
    }
}
