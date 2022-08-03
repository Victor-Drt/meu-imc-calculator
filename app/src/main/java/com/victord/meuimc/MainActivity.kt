package com.victord.meuimc

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import com.victord.meuimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        binding.etPeso.doAfterTextChanged { text ->

        }
        binding.etAltura.doOnTextChanged { text, _, _, _ ->
            binding.tvTitle.text = text
        }
        binding.btCalular.setOnClickListener {
            calcularIMC(binding.etPeso.text.toString(), binding.etAltura.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()

        if (peso != null && altura != null) {
            val imc = peso / (altura * altura)
            binding.tvTitle.text = "%.2f".format(imc)
            classificar(imc)
        }


    }

    private fun classificar(imc: Float) {
        var classificacao = ""
        if (imc < 17) {
            classificacao = "Muito abaixo do peso"
            binding.tvClassificacao.setTextColor(resources.getColor(R.color.peso_muit_abaixo))
        } else if (imc >= 17.0f && imc < 18.5f) {
            classificacao = "Abaixo do peso)"
            binding.tvClassificacao.setTextColor(resources.getColor(R.color.peso_abaixo))
        } else if (imc >= 18.5f && imc < 25) {
            classificacao = "Peso Normal"
            binding.tvClassificacao.setTextColor(resources.getColor(R.color.peso_normal))
        } else if (imc >= 25.0f && imc < 30.0f) {
            classificacao = "Acima do peso"
            binding.tvClassificacao.setTextColor(resources.getColor(R.color.acima_peso))
        } else if (imc >= 30.0f && imc < 35f) {
            classificacao = "Obesidade I"
            binding.tvClassificacao.setTextColor(resources.getColor(R.color.obesidade_1))
        } else if (imc >= 35.0f && imc < 40f) {
            classificacao = "Obesidade II"
            binding.tvClassificacao.setTextColor(resources.getColor(R.color.obesidade_2))
        } else {
            classificacao = "Obesidade III (mórbida)"
            binding.tvClassificacao.setTextColor(resources.getColor(R.color.obesidade_3))
        }
        binding.tvClassificacao.text = classificacao
    }


    //    region lifecycle
    /*
    override fun onStart() {
        super.onStart()
        Log.w("lifecycle", "entrei no START - deixei a tela visivel pra vc")
    }

    override fun onResume() {
        super.onResume()
        Log.w("lifecycle", "entrei no RESUME - agora voce pode interagir com a tela")
    }

    override fun onPause() {
        super.onPause()
        Log.w("lifecycle", "entrei no PAUSE - a tela perdeu o foco, voce nao pode mais interagir")
    }

    override fun onStop() {
        super.onStop()
        Log.w("lifecycle", "entrei no STOP - a tela nao esta mais visivel mas ainda existe")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.w("lifecycle", "entrei no DESTROY - oh! nao a tela foi destruida")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("lifecycle", "entrei no RESTART - A tela esta retornando ao foco")
    }

     */
    //endregion
}