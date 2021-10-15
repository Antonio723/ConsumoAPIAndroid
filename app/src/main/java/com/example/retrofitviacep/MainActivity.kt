package com.example.retrofitviacep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var  buttonBuscarCep: Button
    lateinit var  textViewEndereco: TextView
    lateinit var editTextCep: EditText

    lateinit var botaoBuscarRua: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonBuscarCep = findViewById(R.id.btn_buscar_by_cep)
        textViewEndereco = findViewById(R.id.textViewEndereco)
        editTextCep = findViewById(R.id.editTextCep)



        buttonBuscarCep.setOnClickListener {

            // Obter uma instância da conexão com o Backend
            val remote = RetrofitFactory().retrofitService()

            // Criar uma chamada para o endpoint / cep/ json
            val call: Call<Cep> = remote.getCEP(editTextCep.text.toString())

            // Executar a chamda para a api

            call.enqueue(object : Callback<Cep>{
                override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                    val cep = response.body()
                    textViewEndereco.text = cep.toString()
                }

                override fun onFailure(call: Call<Cep>, t: Throwable) {
                    Log.i("cep", t.message.toString())
                }

            })


        }


    }
}