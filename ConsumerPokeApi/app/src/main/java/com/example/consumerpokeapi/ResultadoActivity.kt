package com.example.consumerpokeapi

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val personagemImagem = findViewById<ImageView>(R.id.personagemImg)
        val nomeTextView = findViewById<TextView>(R.id.nameTv)
        val alturaTextView = findViewById<TextView>(R.id.heightTv)
        val pesoTextView = findViewById<TextView>(R.id.weightTv)

        val nome = intent.getStringExtra("NOME_EXTRA")

        if (nome != null) {
            val pokeApi = RetrofitHelper.getInstance().create(PokeApi::class.java)

            GlobalScope.launch(Dispatchers.IO) {
                try {
                    val response = pokeApi.getPersonagem(nome)
                    if (response.isSuccessful) {
                        val persona = response.body()
                        Log.d("Retorno da API: ", persona.toString())

                        withContext(Dispatchers.Main) {
                            // ⭐️ Usando o Glide para carregar a imagem da URL
                            Glide.with(this@ResultadoActivity)
                                .load(persona?.sprites?.other?.officialArtwork?.front_default)
                                .into(personagemImagem)
                            nomeTextView.text = "NOME: ${persona?.name}"
                            alturaTextView.text = "ALTURA: ${persona?.height}"
                            pesoTextView.text = "PESO: ${persona?.weight}"
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            nomeTextView.text = "Erro: ${response.code()}"
                        }
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        nomeTextView.text = "Ocorreu um erro: ${e.message}"
                    }
                }
            }
        } else {
            nomeTextView.text = "Personagem não encontrado."
        }
    }
}