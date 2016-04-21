/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewConsole;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.Pelanggan;
import model.Pengemudi;
import model.Pesanan;
import model.aplikasi;
import model.kurir;

/**
 *
 * @author The Keong's
 */
public class console {
    private aplikasi model;
    private Scanner sStr;
    private Scanner sInt;
    private Pelanggan pel;
    private Pengemudi pen;
    
    public console(aplikasi model){
        this.model=model;
        sInt = new Scanner(System.in);
        sStr = new Scanner(System.in);
    }
    
    public int inputInteger() {
        try {
            return sInt.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Input must be Integer");
        } finally {
            sInt = new Scanner(System.in);
        }
    }
    
    public void menuPelanggan(){
        int p =0;
        do{
            System.out.println("------selamat datang "+pel.getNama()+"-------");
            System.out.println("Menu Pelanggan : ");
            System.out.println("1. pesanan");
            System.out.println("2. kurir");
            System.out.println("3. Riwayat & status pemesanan");
            System.out.println("0.logout");
            System.out.print("Input menu : ");
            p = inputInteger();
            switch (p){
                case 1 : 
                    System.out.print("Lokasi Awal : ");
                    String awal = sStr.nextLine();
                    System.out.print("Tujuan : ");
                    String akhir = sStr.nextLine();
                    if ((awal != null) && (akhir != null)){
                        Pesanan pes = new Pesanan(awal, akhir);
                        pel.createPesanan(pes);
                    } else{
                        System.out.print("cek kembali inputan");}
                    break;
                case 2 :
                    System.out.print("Lokasi Awal : ");
                    awal = sStr.nextLine();
                    System.out.print("Tujuan : ");
                    akhir = sStr.nextLine();
                    if ((awal != null) && (akhir != null)){
                        kurir k = new kurir(awal, akhir);
                        pel.createKurir(k);
                    } else{
                        System.out.print("cek kembali inputan");}
                    break;
                case 3 :
                    System.out.println("List Riwayat : ");
                    String[][] s= model.getListOutPelanggan(pel);
                    for (int i = 0; i < s.length; i++){
                         System.out.println("   "+i+". jenis "+s[i][0]+" Lokasi awal "+s[i][1]+" Tujuan "+s[i][2]+" Status "+s[i][3]+" Nama Pengemudi "+s[i][4]+" No HP "+s[i][5]); 
                    }break;
                    
                case 0 :
                    System.out.print("log out berhasil");break;
                default :
                        System.out.print("wrong menu inputan");
                    
            }
        }while (p !=0);
    }
    
    public void menuPengemudi(){
        int pil=0;
        do{
            System.out.println("------selamat datang "+pen.getNama()+"-------");
            System.out.println("Menu Pengemudi : ");
            System.out.println("1. ambil pesanan : ");
            System.out.println("2. lihat pesanan : ");
            System.out.println("0.logout");
            System.out.print("Input menu : ");
            pil = inputInteger();
            switch (pil){
                case 1 :
                    System.out.println("List Pesanan : ");
                    String[][] s= model.getListPesanan();
                    for (int i = 0; i < s.length; i++){
                        System.out.println("   "+i+". jenis "+s[i][0]+" Lokasi awal "+s[i][1]+" Tujuan "+s[i][2]+" Status "+s[i][3]+" Nama Pemesan "+s[i][4]+" No HP "+s[i][5]); 
                    }
                    System.out.print("ambil Pesanan no : ");
                    int inp = inputInteger();
                    pen.selectPesanan(s[inp][4],s[inp][1],s[inp][2]);
                case 2 :
                    s= model.getListPengemudi(pen);
                    for (int i = 0; i < s.length; i++){
                        System.out.println("   "+i+". jenis "+s[i][0]+" Lokasi awal "+s[i][1]+" Tujuan "+s[i][2]+" Nama Pemesan "+s[i][3]+" No HP "+s[i][4]); 
                    }
            }
        }while(pil !=0);
        System.out.println("Berhasil Log Out");
    }
    public void menuAdmin(){
        
    }

    public void MenuLogin(){
        System.out.print("UserName : ");
        String name = sStr.nextLine();
        System.out.print("Password : ");
        String pass = sStr.nextLine();
        if (model.cekPelanggan(name, pass)){
            pel = model.getPelanggan(name);
            menuPelanggan();
        }else if(model.cekPengemudi(name, pass)){
            pen = model.getPengemudi(name);
            menuPengemudi();
        }else if ((!model.cekPengemudi(name, pass)) && (!model.cekPelanggan(name, pass))){
            System.out.println("User tidak ada atau username dan pass salah");
        }
            
    }
    public void mainMenu(){
        int pil = 0;
        do{
            try{
                System.out.println("-------SELAMAT DATANG PROGRAM TRANSPORTASI ONLINE----");
                System.out.println("1.Login\n2.Daftar\n0.exit");
                System.out.print("Input menu : ");
                pil = inputInteger();
                switch (pil){
                    case 1 : MenuLogin();break;
                    default:
                        throw new IllegalStateException("Wrong Menu Input");
                }
            }catch (Exception e){
                System.out.println("error : " + e.getMessage());
            }finally {
                sStr = new Scanner(System.in);
            }
        }while(pil !=0);
    }
}
