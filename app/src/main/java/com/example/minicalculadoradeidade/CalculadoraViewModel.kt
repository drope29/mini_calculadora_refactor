package com.example.minicalculadoradeidade

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Calendar

class CalculadoraViewModel : ViewModel() {

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String>
        get() = _resultado

    fun calcularIdade(anoNascimentoStr: String) {
        if (anoNascimentoStr.isNotBlank()) {
            val anoNascimento = anoNascimentoStr.toIntOrNull()
            if (anoNascimento != null) {
                val anoAtual = Calendar.getInstance().get(Calendar.YEAR)
                val idade = anoAtual - anoNascimento
                _resultado.value = "Você tem (ou fará) $idade anos."
            } else {
                _resultado.value = "Ano de nascimento inválido."
            }
        } else {
            _resultado.value = "Por favor, digite o ano de nascimento."
        }
    }
}
