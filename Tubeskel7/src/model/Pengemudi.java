/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Database.Database;
import java.util.ArrayList;

/**
 *
 * @author The Keong's
 */
public class Pengemudi extends orang {
    private ArrayList<Pesanan> pesanan = new ArrayList<>();
    private ArrayList<kurir> kurir = new ArrayList<>();


    public Pengemudi(String nama, long no_hp, String alamat) {
        super(nama, no_hp, alamat);
    }

    public void selectPesanan(String nama,String lokasi,String tujuan){
        Database db = new Database();
        String s = "update tpelanggan set namap = '"+super.getNama()+"',nohpp = '"
                +String.valueOf(super.getNo_hp())+"', status = 'diambil' where nama = '"+nama+"' and awal = '"+lokasi+"' and akhir = '"+tujuan+"' and status = 'belum diambil'";
        db.query(s);
        s = "update tpengemudi set nama = '"+super.getNama()+"', status = 'diambil' where namap = '"+nama+"' and awal = '"+lokasi+"' and akhir = '"+tujuan+"' and status = 'belum diambil'";
        db.query(s);
    }
    
    
    public void LoadPesanan(Pesanan p){
        pesanan.add(p);
    }
    
    public void LoadKurir(kurir k){
        kurir.add(k);
    }
    
    public void addPesanan(Pesanan p){
        pesanan.add(p);
        p.setStatus("pesanan sudah diambil");
    }
    
    public void addKurir(kurir k){
        kurir.add(k);
        k.setStatus("pesanan sudah diambil");
    }
    
    public void delPesanan(int n){
        pesanan.remove(n);
    }
    public void delKurir(int n){
        kurir.remove(n);
    }
    
    public Pesanan getPesanan(int n) {
        return pesanan.get(n);
    }

    public kurir getKurir(int n) {
        return kurir.get(n);
    }    
    
}
