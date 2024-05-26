package com.makaraya.more.data.model

import android.text.Highlights

data class Topic (
    val id: Int,
    val photo: Int,
    val judul: String,
    val penulis: String,
    val tanggal: String,
    val highlightTopic: String,
    val isiTopic: String,
)