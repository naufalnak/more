package com.makaraya.more.model

data class Bengkel(
    val id: Int,
    val namaBengkel: String,
    val deskripsi: String,
    val alamat: String,
    val noTelp: String,
    val photo: Int,
    val rate: Int,
    val nilaiRate: String,
)