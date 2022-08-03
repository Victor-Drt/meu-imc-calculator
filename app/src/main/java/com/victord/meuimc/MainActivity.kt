package com.victord.meuimc

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
        }
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