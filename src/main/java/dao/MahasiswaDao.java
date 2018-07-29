package dao;

import entity.Mahasiswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MahasiswaDao {

    private Connection koneksi;
    private final String dbDriver = "com.mysql.jdbc.Driver";
    private final String dbUrl = "jdbc:mysql://localhost/test";
    private final String dbUsername = "root";
    private final String dbPassword = "";


    public void connect(){
        try {
            Class.forName(dbDriver);
            koneksi = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (Exception err) {
            err.printStackTrace();
        }

    }

    public void disconnect(){
        try {
            if (koneksi != null){
                koneksi.close();
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void simpan(Mahasiswa mahasiswa){
        try {
            connect();
            String sql = "insert into mahasiswa (nim, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, alamat) values (?,?,?,?,?,?)";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setString(1, mahasiswa.getNim());
            ps.setString(2, mahasiswa.getNama());
            ps.setString(3, mahasiswa.getTempatLahir());
            ps.setDate(4, new java.sql.Date(mahasiswa.getTanggalLahir().getTime()));
            ps.setString(5, mahasiswa.getJenisKelamin().toString());
            ps.setString(6, mahasiswa.getAlamat());

            ps.executeUpdate();

            disconnect();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}
