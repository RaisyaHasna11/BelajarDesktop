import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class HaloDesktop {
    public static void main(String[] args) {
        // 1. Tes Koneksi ke Database MySQL XAMPP
        String url = "jdbc:mysql://localhost:3306/db_latihan";
        String user = "root";
        String password = ""; // Bawaan XAMPP tanpa password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke database db_latihan BERHASIL!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL tidak ditemukan! Pastikan file .jar sudah dimasukkan ke Libraries.");
        } catch (SQLException e) {
            System.out.println("Gagal terhubung ke database! Pastikan MySQL di XAMPP sudah dipencet Start.");
            e.printStackTrace();
        }

        // 2. Tampilkan Jendela Java Swing
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Halo, Pemrograman Desktop!");
            JLabel label = new JLabel("Selamat datang di Java Swing & Database!", 
                                       SwingConstants.CENTER);
            
            frame.add(label);
            frame.setSize(420, 200);
            frame.setLocationRelativeTo(null); // Tampil di tengah layar
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}