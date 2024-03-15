package br.com.lucas.jurossimples.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lucas.jurossimples.model.calcularJuros
import br.com.lucas.jurossimples.model.calcularMontante

class JurosScreenViewModel: ViewModel() {

    //CAPITAL
    //Criando uma instancia privada que guarda o valor em MutableLiveData
    private val _capital = MutableLiveData<String>()
    //Criando uma variavel publica que apenas visualiza o valor da intancia
    val capital: LiveData<String> = _capital
    fun onCapitalChanged(novoCapital: String){
        _capital.value = novoCapital
    }

    //Taxa
    private val _taxa = MutableLiveData<String>()
    val taxa: LiveData<String> = _taxa
    fun onTaxaChanged(novaTaxa: String){
        _taxa.value = novaTaxa
    }

    //PERIODO
    private val _tempo = MutableLiveData<String>()
    val tempo: LiveData<String> = _tempo
    fun onTempoChanged(novoTempo: String){
        _tempo.value = novoTempo
    }

    //JUROS
    private val _juros = MutableLiveData<Double>()
    val juros: LiveData<Double> = _juros
    fun onJurosChanged(novoJuros: Double){
        _juros.value = novoJuros
    }

    //MONTANTE
    private val _montante = MutableLiveData<Double>()
    val montante: LiveData<Double> = _montante
    fun onMontanteChanged(novoMontante: Double){
        _montante.value = novoMontante
    }

    //CalcularJuros
    fun calcularJurosViewModel(){
        _juros.value = calcularJuros(_capital.value!!.toDouble(), _taxa.value!!.toDouble(), _tempo.value!!.toDouble())
    }

    fun calcularMontanteViewModel(){
        _montante.value = calcularMontante(_capital.value!!.toDouble(), _juros.value!!.toDouble())
    }

}