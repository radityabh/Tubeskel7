/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubeskel7;

/**
 *
 * @author The Keong's
 */
public class kurir {
    private String jenisBarang;
    private String lokasi;
    private String tujuan;
    private String status="belum di ambil";

    public kurir(String jenisBarang, String lokasi, String tujuan) {
        this.jenisBarang = jenisBarang;
        this.lokasi = lokasi;
        this.tujuan = tujuan;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
