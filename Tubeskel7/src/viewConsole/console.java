/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewConsole;

import java.util.ArrayList;
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
            System.out.println("1. ambil pesanan");
            System.out.println("2. lihat pesanan yang diambi;");
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
                    pen.selectPesanan(s[inp][4],s[inp][1],s[inp][2]);break;
                case 2 :
                    s= model.getListPengemudi(pen);
                    for (int i = 0; i < s.length; i++){
                        System.out.println("   "+i+". jenis "+s[i][0]+" Lokasi awal "+s[i][1]+" Tujuan "+s[i][2]+" Nama Pemesan "+s[i][3]+" No HP "+s[i][4]); 
                    }break;
                case 0 :
                    System.out.print("log out berhasil");break;
                default :
                        System.out.print("wrong menu inputan");
            }
        }while(pil !=0);
        System.out.println("Berhasil Log Out");
    }
    
    public void menuAdmin(){
        int pil =0;
        do{
            System.out.println("Menu");
            System.out.println("1. view pelanggan");
            System.out.println("2. view pengemudi");
            System.out.println("3. view riwayat pelanggan");
            System.out.println("4. view riwayat pengemudi");
            System.out.println("5. del pelanggan");
            System.out.println("6. del pengemudi");
            System.out.println("0. logout");
            System.out.print("Input menu : ");
            pil = inputInteger();
            switch (pil){
                case 1 :
                    ArrayList<Pelanggan> p = model.getListPelanggan();
                    for (int i = 0; i < p.size(); i++){
                        Pelanggan n = p.get(i);
                        System.out.println("UserName "+n.getNama()+" NoHP "+n.getNo_hp()+" pass "+n.getPass());
                    }break;
                case 2 :
                    ArrayList<Pengemudi> pi = model.getListPengemudi();
                    for (int i = 0; i < pi.size(); i++){
                        Pengemudi n = pi.get(i);
                        System.out.println("UserName "+n.getNama()+" NoHP "+n.getNo_hp()+" pass "+n.getPass());
                    }break;
                case 3 :
                    System.out.print("Masukan UserName : ");
                    String s = sStr.nextLine();
                    model.getRiwayatPelanggan(s);
                    break;
                case 4 :
                    System.out.print("Masukan UserName : ");
                    s = sStr.nextLine();
                    model.getRiwayatPengemudi(s);
                    break;
                case 5:
                    System.out.print("Masukan UserName : ");
                    s = sStr.nextLine();
                    model.delPelanggan(s);
                    break;
                case 6:
                    System.out.print("Masukan UserName : ");
                    s = sStr.nextLine();
                    model.delPengemudi(s);
                case 0:
                     System.out.print("log out berhasil");break;
                default :
                        System.out.print("wrong menu inputan");
            }
        }while (pil !=0);
    }
    
    public void menudaftar(){
        int pil=0;
        String nama;
        long nohp;
        String pass;
        do{
            System.out.print("Menu Daftar");
            System.out.print("1. Sebagai Pelanggan");
            System.out.print("2. Sebagai Pengemudi");
            System.out.print("3. Back");
            System.out.print("Input menu : ");
            pil = inputInteger();
            switch (pil){
                case 1 :
                   System.out.print("Username : ");
                   nama = sStr.nextLine();
                   System.out.print("NoHp : ");
                   nohp = Long.valueOf(sStr.nextLine());
                   System.out.print("Pass : ");
                   pass = sStr.nextLine();
                   model.addPelanggan(nama, nohp, pass);
                   break;
                case 2 :
                   System.out.print("Username : ");
                   nama = sStr.nextLine();
                   System.out.print("NoHp : ");
                   nohp = Long.valueOf(sStr.nextLine());
                   System.out.print("Pass : ");
                   pass = sStr.nextLine();
                   model.addPengemudi(nama, nohp, pass);
                   break;
                case 3 :
                    System.out.println("");
                default :
                        System.out.print("wrong menu inputan");
            }
        }while (pil !=0);
        
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
        }else if((name.equals("admin"))&&(pass.equals("admin"))){
            menuAdmin();
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
