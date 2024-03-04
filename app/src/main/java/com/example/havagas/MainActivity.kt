package com.example.havagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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

    }
}