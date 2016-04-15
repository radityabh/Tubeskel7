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
public class Pelanggan extends orang {
    private ArrayList<Pesanan> pesanan = new ArrayList<>();
    private ArrayList<kurir> kurir = new ArrayList<>();


    public Pelanggan(String nama, long no_hp, String pass) {
        super(nama, no_hp, pass);
    }
    
    
    public void savePesanan(Pesanan p){
        Database db = new Database();
        String s = "insert into tpelanggan values('"+super.getNama()+"','Pesanan','"
                +p.getLokasi()+"','"+p.getTujuan()+"',null,null,'"+p.getStatus()+"')";
        String x = "insert into tpengemudi values(null,'Pesanan','"
                +p.getLokasi()+"','"+p.getTujuan()+"','"+super.getNama()+"','"+String.valueOf(super.getNo_hp())+"','"+p.getStatus()+"')";
        db.query(x);
        db.query(s);
    }
    
    public void saveKurir(kurir k){
        Database db = new Database();
        String s = "insert into tpelanggan values('"+super.getNama()+"','Kurir','"
                +k.getLokasi()+"','"+k.getTujuan()+"',null,null,'"+k.getStatus()+"')";
        String x = "insert into tpengemudi values(null,'Kurir','"
                +k.getLokasi()+"','"+k.getTujuan()+"','"+super.getNama()+"','"+String.valueOf(super.getNo_hp())+"','"+k.getStatus()+"')";
        db.query(s);
        db.query(x);
    }
    
    public void LoadPesanan(Pesanan p){
        pesanan.add(p);
    }
    
    public void LoadKurir(kurir k){
        kurir.add(k);
    }
    public void createPesanan(Pesanan p){
        pesanan.add(p);
        savePesanan(p);
    }
    
    public void createKurir(kurir k){
        kurir.add(k);
        saveKurir(k);
    }

    public Pesanan getPesanan(int n) {
        return pesanan.get(n);
    }

    public kurir getKurir(int n) {
        return kurir.get(n);
    }
    
    
    
}
