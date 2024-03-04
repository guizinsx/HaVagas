package com.example.havagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        amb.celularCk.setOnClickListener {
            amb.celularEt.visibility = if (amb.celularCk.isChecked) View.VISIBLE else View.GONE
        }

        amb.formacaoSp.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0 || position == 1){
                    amb.fundmedioformaturaLl.visibility = View.VISIBLE
                    amb.gradespecLl.visibility = View.GONE
                    amb.mestradodoutoradoLl.visibility = View.GONE
                }else{
                    amb.fundmedioformaturaLl.visibility = View.GONE
                }
                if (position == 2 || position == 3){
                    amb.gradespecLl.visibility = View.VISIBLE
                    amb.fundmedioformaturaLl.visibility = View.GONE
                    amb.mestradodoutoradoLl.visibility = View.GONE
                }else{
                    amb.gradespecLl.visibility = View.GONE
                }
                if (position == 4 || position == 5){
                    amb.mestradodoutoradoLl.visibility = View.VISIBLE
                    amb.fundmedioformaturaLl.visibility = View.GONE
                    amb.gradespecLl.visibility = View.GONE
                }else{
                    amb.mestradodoutoradoLl.visibility = View.GONE
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        with(amb){
            salvarBt.setOnClickListener{
                val nome = amb.nomeEt.text
                val email = amb.emailEt.text
                val emailchecked = amb.emailCb.isChecked
                val telefone = amb.telefoneEt.text
                val celular = amb.celularEt.text
                val sexo = if (amb.masculinoRb.isChecked) "Masculino" else "Feminino"
                val nascimento = amb.nascimentoEt.text
                val formacao = amb.formacaoSp.selectedItem.toString()
                val vagas = amb.vagasEt.text

                val infoCadastro = StringBuilder()
                infoCadastro.append("Nome completo: $nome\n")
                infoCadastro.append("Email: $email\n")
                infoCadastro.append("Receber atualização: $emailchecked\n")
                infoCadastro.append("Telefone: $telefone\n")
                if (amb.celularCk.isChecked) {
                    infoCadastro.append("Celular: $celular\n")
                }
                infoCadastro.append("Sexo: $sexo\n")
                infoCadastro.append("Data de nascimento: $nascimento\n")
                infoCadastro.append("Formação: $formacao\n")

                if (amb.fundmedioformaturaLl.visibility == View.VISIBLE) {
                    val anoFormatura = amb.anoformaturaEt.text
                    infoCadastro.append("Ano de formatura (fundamental e medio): $anoFormatura\n")
                }

                if (amb.gradespecLl.visibility == View.VISIBLE) {
                    val anoConclusao = amb.anoconclusaoEt.text
                    val instituicao = amb.instituicaoEt.text
                    infoCadastro.append("Ano de Conclusão (Graduação): $anoConclusao\n")
                    infoCadastro.append("Instituição (Graduação): $instituicao\n")
                }

                if (amb.mestradodoutoradoLl.visibility == View.VISIBLE) {
                    val anoConclusao2 = amb.anoconclusao2Et.text
                    val instituicao2 = amb.instituicao2Et.text
                    val tituloMonografia = amb.tituloEt.text
                    val orientador = amb.orientadorEt.text
                    infoCadastro.append("Ano de Conclusão (Mestrado/Doutorado): $anoConclusao2\n")
                    infoCadastro.append("Instituição (Mestrado/Doutorado): $instituicao2\n")
                    infoCadastro.append("Título de monografia: $tituloMonografia\n")
                    infoCadastro.append("Orientador: $orientador\n")
                }
                infoCadastro.append("Vagas de interesse: $vagas\n")
                println(infoCadastro)
                "HaVagas cadastro: ${infoCadastro}, ".also {
                    Toast.makeText(
                        this@MainActivity,
                        it,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            limparBt.setOnClickListener {
                amb.nomeEt.text.clear()
                amb.emailEt.text.clear()
                amb.emailCb.isChecked = false
                amb.telefoneEt.text.clear()
                amb.comercialRb.isChecked = false
                amb.residencialRb.isChecked = false
                amb.celularCk.isChecked = false
                amb.celularEt.text.clear()
                amb.masculinoRb.isChecked = false
                amb.femininoRb.isChecked = false
                amb.nascimentoEt.text.clear()
                amb.formacaoSp.setSelection(0)
                amb.vagasEt.text.clear()

                if (amb.fundmedioformaturaLl.visibility == View.VISIBLE) {
                    amb.anoformaturaEt.text.clear()
                }

                if (amb.gradespecLl.visibility == View.VISIBLE) {
                    amb.anoconclusaoEt.text.clear()
                    amb.instituicaoEt.text.clear()
                }

                if (amb.mestradodoutoradoLl.visibility == View.VISIBLE) {
                    amb.anoconclusao2Et.text.clear()
                    amb.instituicao2Et.text.clear()
                    amb.tituloEt.text.clear()
                    amb.orientadorEt.text.clear()
                }
            }
        }

    }
}