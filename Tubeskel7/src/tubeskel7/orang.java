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
public abstract class orang {
    private String nama;
    private long no_hp;
    private String alamat;

    public orang(String nama, long no_hp, String alamat) {
        this.nama = nama;
        this.no_hp = no_hp;
        this.alamat = alamat;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public long getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(long no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
}
