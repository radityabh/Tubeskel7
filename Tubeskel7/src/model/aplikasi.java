/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author The Keong's
 */
public class aplikasi {
    
    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Pengemudi> daftarPengemudi;
    
    public aplikasi(){
        daftarPelanggan = new ArrayList<>();
        daftarPengemudi = new ArrayList<>();
        Database db = new Database();
        String s = "select nama, nohp, pass from pelanggan";
        String x = "select nama, nohp, pass from pengemudi";
        ResultSet rs = db.getData(s);
        ResultSet rx = db.getData(x);
        Pelanggan p;
        Pengemudi pm;
        try {
            while (rs.next()){
                String nama = rs.getString("nama");
                long nohp = Long.parseLong(rs.getString("nohp"));
                String pass = rs.getString("pass");
                p = new Pelanggan(nama,nohp,pass);
                daftarPelanggan.add(p);
                s = "Select nama, jenis, awal, akhir, status from tpelanggan where nama = '"+nama+"'";
                ResultSet rs2 = db.getData(s);
                while (rs2.next()){
                    String jenis = rs2.getString("jenis");
                    String awal = rs2.getString("awal");
                    String akhir = rs2.getString("akhir");
                    String status = rs2.getString("status");
                    if (jenis.equals("Pesanan")){
                        Pesanan ps = new Pesanan(awal,akhir);
                        ps.setStatus(status);
                        p.LoadPesanan(ps);
                    } else if (jenis.equals("Kurir")){
                        kurir kr = new kurir(awal,akhir);
                        kr.setStatus(status);
                        p.LoadKurir(kr);
                    }
                }
            }
            while (rx.next()){
                String nama = rx.getString("nama");
                long nohp = Long.parseLong(rx.getString("nohp"));
                String pass = rx.getString("pass");
                pm = new Pengemudi(nama,nohp,pass);
                daftarPengemudi.add(pm);
                x = "Select nama, jenis, awal, akhir, status from tpengemudi where nama = '"+nama+"'";
                ResultSet rx2 = db.getData(x);
                while (rx2.next()){
                    String jenis = rx2.getString("jenis");
                    String awal = rx2.getString("awal");
                    String akhir = rx2.getString("akhir");
                    String status = rx2.getString("status");
                    if (jenis.equals("Pesanan")){
                        Pesanan ps = new Pesanan(awal,akhir);
                        ps.setStatus(status);
                        pm.LoadPesanan(ps);
                    } else if (jenis.equals("Kurir")){
                        kurir kr = new kurir(awal,akhir);
                        kr.setStatus(status);
                        pm.LoadKurir(kr);
                    }
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(aplikasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void savePengemudi(String nama, long noHP,String pass){
        Database db = new Database();
        String s = "insert into pengemudi values('"+nama+"','"
                +String.valueOf(noHP)+"','"+pass+"')";
        db.query(s);
    }
    public void savePelanggan(String nama, long noHP,String pass){
        Database db = new Database();
        String s = "insert into pelanggan values('"+nama+"','"
                +String.valueOf(noHP)+"','"+pass+"')";
        db.query(s);
    }
    
    public void addPengemudi(String nama, long noHP,String pass){
        Pengemudi p = new Pengemudi(nama,noHP,pass);
        daftarPengemudi.add(p);
        savePengemudi(nama,noHP,pass);
    }
    
    public void addPelanggan(String nama, long noHP,String pass){
        Pelanggan p = new Pelanggan(nama,noHP,pass);
        daftarPelanggan.add(p);
        savePelanggan(nama,noHP,pass);
    }
    
    public Pelanggan getPelanggan(String user){
        for (int n = 0;n < daftarPelanggan.size();n++){
            if (daftarPelanggan.get(n).getNama().equals(user))
                return daftarPelanggan.get(n);
        }
        return null;
    }
    
    public Pengemudi getPengemudi(String user){
        for (int n = 0;n < daftarPengemudi.size();n++){
            if (daftarPengemudi.get(n).getNama().equals(user))
                return daftarPengemudi.get(n);
        }
        return null;
    }
    
   public boolean cekPelanggan(String nama,String pass){
       for(int i=0;i<daftarPelanggan.size();i++){
           if ((daftarPelanggan.get(i).getNama().equals(nama)) && (daftarPelanggan.get(i).getPass().equals(pass)))
               return true;
       }return false;
   }
   
   public boolean cekPengemudi(String nama,String pass){
       for(int i=0;i<daftarPengemudi.size();i++){
           if ((daftarPengemudi.get(i).getNama().equals(nama)) && (daftarPengemudi.get(i).getPass().equals(pass)))
               return true;
       }return false;
   }
    
}
