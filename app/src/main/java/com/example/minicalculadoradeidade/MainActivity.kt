package com.example.minicalculadoradeidade

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CalculadoraViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obter uma instância do ViewModel
        viewModel = ViewModelProvider(this).get(CalculadoraViewModel::class.java)

        // Referenciar os componentes da UI
        val editAnoNascimento: EditText = findViewById(R.id.edit_ano_nascimento)
        val buttonCalcular: Button = findViewById(R.id.button_calcular)
        val textResultado: TextView = findViewById(R.id.text_resultado_idade)

        // Configurar o listener do botão
        buttonCalcular.setOnClickListener {
            val anoNascimentoStr = editAnoNascimento.text.toString()
            viewModel.calcularIdade(anoNascimentoStr)
        }

        // Observar o resultado do ViewModel
        viewModel.resultado.observe(this) { resultado ->
            textResultado.text = resultado
        }
    }
}
