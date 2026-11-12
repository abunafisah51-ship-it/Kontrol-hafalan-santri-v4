package com.santri.kontrolhafalanv4;
public class BUKOMFinal {
    // ============ 1. SAMBUTAN A - TIDAK DIBEDAKAN, SAMA UNTUK SEMUA ============
    public static final String BISMILLAH = "بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ";
    public static final String SALAM = "Assalamu'alaikum Warahmatullahi Wabarakatuh";
    public static final String JUDUL = "Selamat Datang di BUKOM Santri";
    public static final String SUBJUDUL = "Kontrol Hafalan - Program 30 Juz";
    public static final String HADITS = "Sebaik-baik kalian adalah orang yang mempelajari Al-Qur'an dan mengajarkannya. (HR. Bukhari)";
    public static final String LOGIN_TEXT = "Silakan Masuk dengan Nomor WA Antum";

    // ============ 2. TUJUAN RESMI - 5 POIN ============
    public static final String TUJUAN = "Tujuan Pembuatan Aplikasi\n\n1. Mewujudkan pencatatan hafalan santri yang tertib, akurat, dan terdokumentasi secara sistematis.\n\n2. Memudahkan Pentasmi' Al-Qur'an dalam mengontrol dan mengevaluasi perkembangan hafalan santri setiap hari.\n\n3. Membantu santri dalam mencapai target Program 30 Juz secara terarah, terukur, dan berkesinambungan sesuai jenjang pendidikan.\n\n4. Memberikan transparansi informasi kepada Wali santri mengenai perkembangan hafalan putra-putrinya.\n\n5. Mendukung Admin dalam pengelolaan data santri, Pentasmi', dan laporan hafalan secara terpusat dan efisien.";

    // ============ 3. KELAS & TARGET HAFALAN ============
    public static final String KELAS_1 = "Kelas 1";
    public static final String KELAS_2 = "Kelas 2";
    public static final String KELAS_3 = "Kelas 3";
    public static final int TARGET_KELAS_1_JUZ = 2;
    public static final int TARGET_KELAS_2_JUZ = 5;
    public static final int TARGET_KELAS_3_JUZ = 10;
    public static final int TARGET_AKHIR_JUZ = 30;

    // ============ 4. MAX 6 ANAK PER PENTASMI' ============
    public static final int MAX_ANAK_PER_PENTASMI = 6;
    public static final String ATURAN_MAX = "Maksimal 6 santri per Pentasmi', tidak boleh lebih.";

    // ============ 5. PINDAH SEMENTARA - PILIHAN B ============
    public static final String JUDUL_PINDAH = "Pindah Sementara";
    public static final String KETERANGAN_PINDAH = "Santri pindah sementara, data tetap tersimpan, tidak dihapus. Santri bisa kembali kapan saja tanpa daftar ulang.";
    public static final int MAX_HARI_PINDAH = 30;
    public static final String STATUS_PINDAH = "PINDAH_SEMENTARA";
    public static final String STATUS_AKTIF = "AKTIF";
    public static final String PESAN_KEMBALI = "Selamat datang kembali, silakan lanjutkan hafalan antum.";

    // ============ 6. LOGIN WALI PAKAI NO WA ============
    public static final String JUDUL_LOGIN_WALI = "Login Wali Santri";
    public static final String HINT_WA = "Masukkan Nomor WA Wali, contoh: 081234567890";
    public static final String TOMBOL_MASUK_WALI = "Masuk dengan Nomor WA";
    public static final String PESAN_WALI_SUKSES = "Selamat datang Wali Santri, silakan lihat perkembangan hafalan putra-putri antum.";
    public static final String PESAN_WALI_GAGAL = "Nomor WA tidak ditemukan, silakan hubungi Admin.";

    // ============ 7. LAPORAN WA ============
    public static final String LAPORAN_JUDUL = "Laporan Hafalan Santri";
    public static final String LAPORAN_VIA = "Laporan dikirim via WhatsApp ke Wali Santri setiap hari setelah setoran.";
    public static final String FORMAT_LAPORAN = "Bismillah, Laporan Hafalan Ananda [NAMA] hari ini: Juz [JUZ], Halaman [HAL], Keterangan: [LANCAR / PERLU PENGULANGAN]. Jazakumullahu Khairan.";

    public static boolean isNomorWaValid(String wa) {
        if (wa == null) return false;
        wa = wa.trim();
        return wa.length() >= 10 && wa.length() <= 15;
    }
}
