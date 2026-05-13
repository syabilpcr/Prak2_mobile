package com.example.bastardapps.Home.pertemuan_2

fun main() {
    println("Hai rekan rekan...")
    println("Selamat datang di bahasa pemograman kotlin")

    println("========================")

    var angka = 15
    println("hasil dari 15 + 10 = ${angka + 10}")

    val nilaiInt = 10000
    val nilaiDouble = 100.003
    val nilaiFloat = 1000.0f

    println("nilai Integer = $nilaiInt")
    println("nilai Double = $nilaiDouble")
    println("nilai Flot = $nilaiFloat")

    println("=========STRING========")
    val huruf = 'a'
    println("ini pengunaan karakter '$huruf'")

    val nilaiString = "mawar"
    println("halo $nilaiString!\nApa kabar?")

    println("=======KONDISI=======")

    val nilai = 10
    if(nilai<0)
        println("bilangan genap")
    else {
        if(nilai%2 == 0)
            println("bilangan genap")
        else
            println("bilangan ganjil")
    }

    println("========PERULANGAN========")
    val kampusKu: Array<String> = arrayOf("kampus", "politeknik", "caltex", "riau")
    for (kampus: String in kampusKu) {
        println(kampus)
    }
}