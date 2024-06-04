package com.makaraya.more.ui.screen.layanan.viewmodel

import androidx.lifecycle.ViewModel
import com.makaraya.more.data.model.PanggilMekanik
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PanggilMekanikViewModel : ViewModel() {

    private val _showBottomSheet = MutableStateFlow(false)
    val showBottomSheet: StateFlow<Boolean> = _showBottomSheet

    private val _mekanikRequest = MutableStateFlow(PanggilMekanik())
    val mekanikRequest: StateFlow<PanggilMekanik> = _mekanikRequest

    fun updateDetailLokasi(detailLokasi: String, patokan: String) {
        _mekanikRequest.value = _mekanikRequest.value.copy(detailLokasi = detailLokasi, patokan = patokan)
    }

    fun updateSelectedKendaraan(selectedKendaraan: String) {
        _mekanikRequest.value = _mekanikRequest.value.copy(selectedKendaraan = selectedKendaraan)
    }

    fun updateKendalaKendaraan(kendalaKendaraan: String) {
        _mekanikRequest.value = _mekanikRequest.value.copy(kendalaKendaraan = kendalaKendaraan)
    }

    fun showBottomSheet() {
        _showBottomSheet.value = true
    }

    fun hideBottomSheet() {
        _showBottomSheet.value = false
    }
}