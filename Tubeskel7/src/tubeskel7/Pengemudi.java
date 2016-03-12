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
public class Pengemudi extends orang {
    
 private Pesanan[] pesanan = new Pesanan[10];
    private kurir[] kurir = new kurir[10];
    private int nPesanan=1;
    private int nKurir=1;

    public Pengemudi(String nama, long no_hp, String alamat) {
        super(nama, no_hp, alamat);
    }
    public void addPesanan(Pesanan p){
        if (nPesanan <= 10){
            this.pesanan[nPesanan] = p;
            nPesanan++;
            p.setStatus("pesanan sudah diambil");
        }else
            System.out.println("Pesanan maksimal 10");
    }
    
    public void addKurir(kurir k){
        if (nKurir <= 10){
            this.kurir[nKurir] = k;
            nKurir++;
            k.setStatus("pesanan sudah diambil");
        }else
            System.out.println("Pesanan maksimal 10");
    }
    
    public void delPesanan(int n){
        for(int i=n;i < nPesanan;i++){
            this.pesanan[i]=pesanan[i+1];
        }
        nPesanan--;
    }
    public void delKurir(int n){
        for(int i=n;i<nKurir;i++){
            this.kurir[i]=kurir[i+1];
        }
        nKurir--;
    }
    
    public Pesanan getPesanan(int n) {
        return pesanan[n];
    }

    public kurir getKurir(int n) {
        return kurir[n];
    }    
    
}
