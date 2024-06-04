package com.makaraya.more.ui.screen.layanan.viewmodel

import androidx.lifecycle.ViewModel
import com.makaraya.more.data.DummyData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class ReservationViewModel : ViewModel() {

    private val _selectedOptions = MutableStateFlow(List(DummyData.serviceOptions.size) { false })
    val selectedOptions: StateFlow<List<Boolean>> = _selectedOptions

    private val _selectedVehicle = MutableStateFlow("")
    val selectedVehicle: StateFlow<String> = _selectedVehicle

    private val _selectedText = MutableStateFlow("Pilih waktu")
    val selectedText: StateFlow<String> = _selectedText

    private val _isExpanded = MutableStateFlow(false)
    val isExpanded: StateFlow<Boolean> = _isExpanded

    private val _scheduleDate = MutableStateFlow("")
    val scheduleDate: StateFlow<String> = _scheduleDate

    private val _showDatePicker = MutableStateFlow(false)
    val showDatePicker: StateFlow<Boolean> = _showDatePicker

    private val date = Calendar.getInstance().timeInMillis
    private val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    val datePickerState = MutableStateFlow(date)

    fun onOptionSelected(index: Int, isChecked: Boolean) {
        _selectedOptions.value = _selectedOptions.value.toMutableList().apply {
            this[index] = isChecked
        }
    }

    fun onVehicleSelected(vehicleType: String) {
        _selectedVehicle.value = vehicleType
    }

    fun onTextSelected(text: String) {
        _selectedText.value = text
    }

    fun onExpandedChanged() {
        _isExpanded.value = !_isExpanded.value
    }

    fun onDateSelected(dateMillis: Long) {
        _scheduleDate.value = formatter.format(Date(dateMillis))
        _showDatePicker.value = false
    }

    fun showDatePicker() {
        _showDatePicker.value = true
    }

    fun dismissDatePicker() {
        _showDatePicker.value = false
    }
}