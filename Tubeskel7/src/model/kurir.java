/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author The Keong's
 */
public class kurir {
    private String lokasi;
    private String tujuan;
    private String status="belum diambil";

    public kurir(String lokasi, String tujuan) {
        this.lokasi = lokasi;
        this.tujuan = tujuan;
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

    @Override
    public String toString() {
        return "kurir{" + "lokasi=" + lokasi + ", tujuan=" + tujuan + ", status=" + status + '}';
    }
    
    
}
