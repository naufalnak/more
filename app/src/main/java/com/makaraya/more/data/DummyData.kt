package com.makaraya.more.data

import com.makaraya.more.R
import com.makaraya.more.model.OnboardingPage
import com.makaraya.more.model.Topic
import com.makaraya.more.model.Bengkel

object DummyData {
    val onboardingPages = listOf(
        OnboardingPage(
            "Perawatan \n" +
                    "Kendaraan dengan \n" +
                    "Mudah dan Nyaman", R.drawable.onboard1
        ),

        OnboardingPage(
            "Nikmati perawatan \n" +
                    "kendaraan pribadi dari \n" +
                    "rumah sendiri",
            R.drawable.onboard2
        ),

        OnboardingPage(
            "Reservasi perawatan \n" +
                    "kendaraan pribadi sesuai \n" +
                    "jadwal yang kamu mau",
            R.drawable.onboard3
        )
    )

    val topicPages = listOf(
        Topic(
            photo = R.drawable.topik1,
            judul = "Solusi Mudah untuk Mengatasi Masalah Starter Mobil Anda",
            penulis = "Irvansius Risky",
            tanggal = "August 17, 2020",
            highlightTopic = "Lorem ipsum dolor sit amet consectetur. Enim senectus neque faucibus cursus ut gravida. Ac pulvinar pulvinar rutrum at in lectus in.",
            isiTopic = "Lorem ipsum dolor sit amet consectetur. Enim senectus neque faucibus cursus ut gravida. Ac pulvinar pulvinar rutrum at in lectus in. Auctor proin pulvinar massa ultricies. Condimentum molestie nec habitasse mi feugiat sed ornare et condimentum. Vitae ac potenti faucibus vulputate aenean in leo cursus. Felis accumsan posuere aliquam enim accumsan. Erat ullamcorper gravida in ac sagittis a amet.\n" +
                    "\n" +
                    "Cum egestas congue laoreet ultricies. Lobortis dictumst augue orci fermentum vestibulum. Parturient blandit id in lectus erat vulputate arcu eu. Volutpat id aliquam interdum at pretium amet ut. Lacus lacus consequat urna faucibus ut eget cras enim. Lobortis ultricies consequat aliquam pellentesque. Scelerisque aliquet lectus facilisis elit diam ac. Iaculis neque netus magna eget sit sociis ac cras suspendisse. Morbi nisl libero massa ornare massa gravida. Nulla condimentum massa netus gravida sit volutpat lectus. Enim purus massa in sed."
        ),
        Topic(
            photo = R.drawable.topik1,
            judul = "Tips: Cara Memperpanjang Umur Ban Mobil Anda",
            penulis = "Rizky Yuniharto",
            tanggal = "June 04, 2021",
            highlightTopic = "Lorem ipsum dolor sit amet consectetur. Enim senectus neque faucibus cursus ut gravida. Ac pulvinar pulvinar rutrum at in lectus in.",
            isiTopic = "Lorem ipsum dolor sit amet consectetur. Enim senectus neque faucibus cursus ut gravida. Ac pulvinar pulvinar rutrum at in lectus in. Auctor proin pulvinar massa ultricies. Condimentum molestie nec habitasse mi feugiat sed ornare et condimentum. Vitae ac potenti faucibus vulputate aenean in leo cursus. Felis accumsan posuere aliquam enim accumsan. Erat ullamcorper gravida in ac sagittis a amet.\n" +
                    "\n" +
                    "Cum egestas congue laoreet ultricies. Lobortis dictumst augue orci fermentum vestibulum. Parturient blandit id in lectus erat vulputate arcu eu. Volutpat id aliquam interdum at pretium amet ut. Lacus lacus consequat urna faucibus ut eget cras enim. Lobortis ultricies consequat aliquam pellentesque. Scelerisque aliquet lectus facilisis elit diam ac. Iaculis neque netus magna eget sit sociis ac cras suspendisse. Morbi nisl libero massa ornare massa gravida. Nulla condimentum massa netus gravida sit volutpat lectus. Enim purus massa in sed."
        ),
        Topic(
            photo = R.drawable.topik1,
            judul = "7 Langkah Sederhana untuk Merawat Mobil Anda Sendiri",
            penulis = "Akbar Andriansyah",
            tanggal = "Oktober 10, 2019",
            highlightTopic = "Lorem ipsum dolor sit amet consectetur. Enim senectus neque faucibus cursus ut gravida. Ac pulvinar pulvinar rutrum at in lectus in.",
            isiTopic = "Lorem ipsum dolor sit amet consectetur. Enim senectus neque faucibus cursus ut gravida. Ac pulvinar pulvinar rutrum at in lectus in. Auctor proin pulvinar massa ultricies. Condimentum molestie nec habitasse mi feugiat sed ornare et condimentum. Vitae ac potenti faucibus vulputate aenean in leo cursus. Felis accumsan posuere aliquam enim accumsan. Erat ullamcorper gravida in ac sagittis a amet.\n" +
                    "\n" +
                    "Cum egestas congue laoreet ultricies. Lobortis dictumst augue orci fermentum vestibulum. Parturient blandit id in lectus erat vulputate arcu eu. Volutpat id aliquam interdum at pretium amet ut. Lacus lacus consequat urna faucibus ut eget cras enim. Lobortis ultricies consequat aliquam pellentesque. Scelerisque aliquet lectus facilisis elit diam ac. Iaculis neque netus magna eget sit sociis ac cras suspendisse. Morbi nisl libero massa ornare massa gravida. Nulla condimentum massa netus gravida sit volutpat lectus. Enim purus massa in sed."
        ),
    )

    val bengkelPages = listOf(
        Bengkel(
            namaBengkel = "BENGKEL ANUGRAH",
            deskripsi = "Apakah kendaraan Anda butuh perawatan atau perbaikan? Kami siap membantu Anda! Dengan pengalaman lebih dari 10 tahun, Bengkel Anugrah telah menjadi pilihan terpercaya untuk para pemilik kendaraan.",
            alamat = "Jl. Gatot Subroto No. 52 Bantul, Yogyakarta",
            noTelp = "081-456-098-321",
            photo = R.drawable.rekomenbengkel,
            rate = R.drawable.starrekomen,
            nilaiRate = "4.5",
        )
    )
}