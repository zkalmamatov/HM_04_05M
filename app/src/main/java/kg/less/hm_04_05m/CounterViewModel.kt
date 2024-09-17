package kg.less.hm_04_05m

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    private val _counterData = MutableLiveData<Int>()

    val counterData: LiveData<Int> = _counterData

    private var counter = 0

    init {
        _counterData.value = counter
    }

    fun incrementCounter() {
        counter++
        _counterData.value = counter
    }
    fun decrementCounter() {
        counter--
        _counterData.value = counter
    }
    fun resetCounter() {
        counter = 0
        _counterData.value = counter
    }
}