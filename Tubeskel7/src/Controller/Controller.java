/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import View.Daftar;
import View.Login;
import View.Panelcontainer;
import View.menuPelanggan;
import View.menuPengemudi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Pelanggan;
import model.Pengemudi;
import model.Pesanan;
import model.aplikasi;
import model.kurir;

/**
 *
 * @author The Keong's
 */
public class Controller extends MouseAdapter implements ActionListener {
    private aplikasi model;
    private Panelcontainer view;
    
    private String currentView;
    private String namaSeleksi = "";
    private String lokasiSeleksi = "";
    private String tujuanSeleksi = "";
    private JPanel mainPanel;
    
    private Login L;
    private Daftar D;
    private menuPelanggan mP;
    private menuPengemudi mG;
    
    private Pelanggan p;
    private Pengemudi pd;
    
    public Controller(aplikasi model){
        this.model = model;
        this.view = new Panelcontainer();
        
        L = new Login();
        D = new Daftar();
        //K = new kosong();
        mP = new menuPelanggan();
        mG = new menuPengemudi();
        
        L.addListener(this);
        D.addListener(this);
        mP.addListener(this);
        mG.addListener(this);
        mG.addAdapter(this);
        
        mainPanel = view.getMainPanel();
        mainPanel.add(L,"0");
        mainPanel.add(D,"1");
        //mainPanel.add(K,"2");
        mainPanel.add(mP,"3");
        mainPanel.add(mG,"4");
        currentView = "0";
        
        view.getCardLayout().show(mainPanel, currentView);
        view.setVisible(true);
        view.addListener(this);
        
    }
    
    public String[][] getListOutPelanggan(){
        Database db = new Database();
        int a = 0;
        String s = "Select count(*) jum from tpelanggan where nama ='"+p.getNama()+"'";
        ResultSet rs = db.getData(s);
        try {
            while (rs.next()){
                a = rs.getInt("jum");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        s = "Select jenis, awal, akhir, status, namap, nohpp from tpelanggan where nama = '"+p.getNama()+"'";
        String out[][] = new String[a][6];
        rs = db.getData(s);
        try {
            int i = 0;
            while (rs.next()){
                out[i][0] = rs.getString("jenis");
                out[i][1] = rs.getString("awal");
                out[i][2] = rs.getString("akhir");
                out[i][3] = rs.getString("status");
                out[i][4] = rs.getString("namap");
                out[i][5] = rs.getString("nohpp");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }    
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    
    public String[][] getListPesanan(){
        Database db = new Database();
        int a = 0;
        String s = "Select count(*) jum from tpengemudi where status ='belum diambil' or status = 'belum di ambil'";
        ResultSet rs = db.getData(s);
        try {
            while (rs.next()){
                a = rs.getInt("jum");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        s = "Select jenis, awal, akhir, status, namap, nohpp from tpengemudi where status ='belum diambil' or status = 'belum di ambil'";
        String out[][] = new String[a][6];
        rs = db.getData(s);
        try {
            int i = 0;
            while (rs.next()){
                out[i][0] = rs.getString("jenis");
                out[i][1] = rs.getString("awal");
                out[i][2] = rs.getString("akhir");
                out[i][3] = rs.getString("status");
                out[i][4] = rs.getString("namap");
                out[i][5] = rs.getString("nohpp");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }    
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    
    public String[][] getListPengemudi(){
        Database db = new Database();
        int a = 0;
        String s = "Select count(*) jum from tpengemudi where nama ='"+pd.getNama()+"'";
        ResultSet rs = db.getData(s);
        try {
            while (rs.next()){
                a = rs.getInt("jum");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        s = "Select jenis, awal, akhir, namap, nohpp from tpengemudi where nama = '"+pd.getNama()+"'";
        String out[][] = new String[a][5];
        rs = db.getData(s);
        try {
            int i = 0;
            while (rs.next()){
                out[i][0] = rs.getString("jenis");
                out[i][1] = rs.getString("awal");
                out[i][2] = rs.getString("akhir");
                out[i][3] = rs.getString("namap");
                out[i][4] = rs.getString("nohpp");
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }    
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out;
    }
    
    public void mousePressed(MouseEvent e){
        Object source = e.getSource();
        if (source.equals(mG.tabelPesananSelected())&&mG.getSelectedPesanan() >= 0){
            String[][] a = getListPesanan();
            namaSeleksi = a[mG.getSelectedPesanan()][4];
            lokasiSeleksi = a[mG.getSelectedPesanan()][1];
            tujuanSeleksi = a[mG.getSelectedPesanan()][2];
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if (source.equals(view.getBtnExit())) {
            System.exit(0);
        }
        if (currentView.equals("0")){
            if(source.equals(L.btnMasuk())){
                if (L.getUser().equals("")||L.getPass().equals("")){
                    JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong", "Peringatan", JOptionPane.ERROR_MESSAGE);
                } else if (model.cekPelanggan(L.getUser(), L.getPass())){
                    mP.reset();
                    currentView="3";
                    p = model.getPelanggan(L.getUser());
                    mP.setListOutPelanggan(getListOutPelanggan());
                    view.getCardLayout().show(mainPanel, currentView);
                }else if (model.cekPengemudi(L.getUser(), L.getPass())){
                    currentView="4";
                    view.getCardLayout().show(mainPanel, currentView);
                    pd = model.getPengemudi(L.getUser());
                    mG.setListOutPesanan(getListPesanan());
                    mG.setListOutPengemudi(getListPengemudi());
                } else if ((!model.cekPengemudi(L.getUser(), L.getPass())) && (!model.cekPelanggan(L.getUser(), L.getPass()))){
                    JOptionPane.showMessageDialog(null, "User tidak ada atau username dan pass salah", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }    
            } else if(source.equals(L.btnDaftar())){
                currentView="1";
                view.getCardLayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("1")){
            if(source.equals(D.btnReg())){
                if (D.regUser().equals("")||D.regPass().equals("")||D.regNoHP() == 0){
                    JOptionPane.showMessageDialog(null, "cek kembali inputan", "Peringatan", JOptionPane.ERROR_MESSAGE);
                }else if (D.getPosisi() == "pelanggan"){
                    JOptionPane.showMessageDialog(null, "Pendaftaran Berhasil");
                    model.addPelanggan(D.regUser(), D.regNoHP(), D.regPass());
                    D.reset();
                    currentView="1";
                    view.getCardLayout().show(mainPanel, currentView);
                }else if (D.getPosisi()=="pengemudi"){
                    JOptionPane.showMessageDialog(null, "pendaftaran berhasil");
                    model.addPengemudi(D.regUser(), D.regNoHP(), D.regPass());
                    D.reset();
                    currentView="1";
                    view.getCardLayout().show(mainPanel, currentView);
                }
            } else if(source.equals(D.btnBackReg())){
                L.reset();
                currentView="0";
                view.getCardLayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("3")){
            if(source.equals(mP.getPesan())){
                
                if (mP.getJenis() == "pesanan"){
                    Pesanan pes = new Pesanan(mP.getAwal(),mP.getAkhir());
                    p.createPesanan(pes);
                    mP.reset();
                    mP.setListOutPelanggan(getListOutPelanggan());
                    currentView="3";
                    view.getCardLayout().show(mainPanel, currentView);
                } else if(mP.getJenis() == "kurir"){
                    kurir kr = new kurir(mP.getAwal(),mP.getAkhir());
                    p.createKurir(kr);
                    mP.reset();
                    mP.setListOutPelanggan(getListOutPelanggan());
                    currentView="3";
                    view.getCardLayout().show(mainPanel, currentView);
                }
            } else if(source.equals(mP.getLogout())){
                L.reset();
                currentView="0";
                view.getCardLayout().show(mainPanel, currentView);
            }
        }else if (currentView.equals("4")){
                if (source.equals(mG.buttonAmbilPressed())){
                    if (namaSeleksi.equals(""))
                        System.out.println("Kasih joptionpane");
                    else {
                        pd.selectPesanan(namaSeleksi,lokasiSeleksi,tujuanSeleksi);
                        mG.setListOutPesanan(getListPesanan());
                        mG.setListOutPengemudi(getListPengemudi());
                    }
                }else if(source.equals(mG.btnLog())){
                    L.reset();
                    currentView="0";
                    view.getCardLayout().show(mainPanel, currentView);
                }
        }
    }
}
