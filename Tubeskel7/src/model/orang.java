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
public abstract class orang {
    private String nama;
    private long no_hp;
    private String pass;

    public orang(String nama, long no_hp, String pass) {
        this.nama = nama;
        this.no_hp = no_hp;
        this.pass = pass;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "orang{" + "nama=" + nama + ", no_hp=" + no_hp + ", pass=" + pass + '}';
    }
    
}
