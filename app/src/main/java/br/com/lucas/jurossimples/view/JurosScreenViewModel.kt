package br.com.lucas.jurossimples.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JurosScreenViewModel: ViewModel() {

    //Criando uma instancia privada que guarda o valor em MutableLiveData
    private val _capital = MutableLiveData<String>()
    //Criando uma variavel publica que apenas visualiza o valor da intancia
    val capital: LiveData<String> = _capital
    fun onCapitalChanged(novoCapital: String){
        _capital.value = novoCapital
    }

    private val _taxa = MutableLiveData<String>()
    val taxa: LiveData<String> = _taxa
    fun onTaxaChanged(novaTaxa: String){
        _taxa.value = novaTaxa
    }

    private val _tempo = MutableLiveData<String>()
    val tempo: LiveData<String> = _tempo
    fun onTempoChanged(novoTempo: String){
        _tempo.value = novoTempo
    }
}