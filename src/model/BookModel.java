package model;

import dbHelper.dbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;

public class BookModel {
    
    private int ID;
    private String İsim;
    private String Tur;
    private String Yazar;
    private int SayfaSayisi;
    private String Tarih;

    public BookModel(int ID,String İsim, String Tur, String Yazar, int SayfaSayisi, String Tarih) {
        this.ID = ID;
        this.İsim = İsim;
        this.Tur = Tur;
        this.Yazar = Yazar;
        this.SayfaSayisi = SayfaSayisi;
        this.Tarih = Tarih;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
   

    public String getİsim() {
        return İsim;
    }

    public void setİsim(String İsim) {
        this.İsim = İsim;
    }

    public String getTur() {
        return Tur;
    }

    public void setTur(String Tur) {
        this.Tur = Tur;
    }

    public String getYazar() {
        return Yazar;
    }

    public void setYazar(String Yazar) {
        this.Yazar = Yazar;
    }

    public int getSayfaSayisi() {
        return SayfaSayisi;
    }

    public void setSayfaSayisi(int SayfaSayisi) {
        this.SayfaSayisi = SayfaSayisi;
    }

    public String getTarih() {
        return Tarih;
    }

    public void setTarih(String Tarih) {
        this.Tarih = Tarih;
    }
    
    public static ArrayList<BookModel>getList(){
        Connection connection = null;
        dbHelper dbHelper = new dbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<BookModel> bookList = null;  
        
         try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM bookandmovie.booklist ;";
            resultSet = statement.executeQuery(sql);
            bookList = new ArrayList<>();
            while (resultSet.next()) {
                BookModel book = new BookModel(
                        resultSet.getInt("ID"),
                        resultSet.getString("isim"),
                        resultSet.getString("tur"),
                        resultSet.getString("yazar"),
                        resultSet.getInt("SayfaSayisi"),
                        resultSet.getString("tarih")
                        
                );
                bookList.add(book);
            }
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
            }
            try {
                connection.close();
            } catch (SQLException ex) {
            }
        }
        return bookList;
    }
    

    
    
    

    public void BookDatabaseAdd() {
        Connection connection = null;
        PreparedStatement statement = null;
        dbHelper dbHelper = new dbHelper();

        try {
            // Veritabanı bağlantısını oluştur
            connection = dbHelper.getConnection();  // Bu metodunuzun nasıl çalıştığını bilemem, uygun şekilde çağrılmalı

            // SQL sorgusu
            String sql = "INSERT INTO booklist (isim, tur, yazar, sayfaSayisi, tarih) VALUES (?, ?, ?, ?, ?)";

            // PreparedStatement oluştur
            statement = connection.prepareStatement(sql);
            statement.setString(1, İsim);
            statement.setString(2, Tur);
            statement.setString(3, Yazar);
            statement.setInt(4, SayfaSayisi);
            statement.setString(5, Tarih);

            // Sorguyu yürüt
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

   public void BookDatabaseDel() {
    Connection connection = null;
    PreparedStatement statement = null;
    dbHelper dbHelper = new dbHelper();

    try {
        // Veritabanı bağlantısını oluştur
        connection = dbHelper.getConnection();  // Bu metodunuzun nasıl çalıştığını bilemem, uygun şekilde çağrılmalı

        // SQL sorgusu
        String sql = "DELETE FROM booklist WHERE isim = ?";

        // PreparedStatement oluştur
        statement = connection.prepareStatement(sql);
        statement.setString(1, İsim);

        // Sorguyu yürüt
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
   
   public static ArrayList<BookModel>bookReadGetList(){
        Connection connection = null;
        dbHelper dbHelper = new dbHelper();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<BookModel> bookList = null;  
        
         try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            String sql = "SELECT * FROM bookandmovie.bookread ;";
            resultSet = statement.executeQuery(sql);
            bookList = new ArrayList<>();
            while (resultSet.next()) {
                BookModel book = new BookModel(
                        resultSet.getInt("ID"),
                        resultSet.getString("isim"),
                        resultSet.getString("tur"),
                        resultSet.getString("yazar"),
                        resultSet.getInt("SayfaSayisi"),
                        resultSet.getString("tarih")
                        
                );
                bookList.add(book);
            }
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
            }
            try {
                connection.close();
            } catch (SQLException ex) {
            }
        }
        return bookList;
    }
    

    
    
    

    public void BookReadDatabaseAdd() {
        Connection connection = null;
        PreparedStatement statement = null;
        dbHelper dbHelper = new dbHelper();

        try {
            // Veritabanı bağlantısını oluştur
            connection = dbHelper.getConnection();  // Bu metodunuzun nasıl çalıştığını bilemem, uygun şekilde çağrılmalı

            // SQL sorgusu
            String sql = "INSERT INTO bookandmovie.bookread (isim, tur, yazar, sayfaSayisi, tarih) VALUES (?, ?, ?, ?, ?)";

            // PreparedStatement oluştur
            statement = connection.prepareStatement(sql);
            statement.setString(1, İsim);
            statement.setString(2, Tur);
            statement.setString(3, Yazar);
            statement.setInt(4, SayfaSayisi);
            statement.setString(5, Tarih);

            // Sorguyu yürüt
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

   public void BookReadDatabaseDel() {
    Connection connection = null;
    PreparedStatement statement = null;
    dbHelper dbHelper = new dbHelper();

    try {
        // Veritabanı bağlantısını oluştur
        connection = dbHelper.getConnection();  // Bu metodunuzun nasıl çalıştığını bilemem, uygun şekilde çağrılmalı

        // SQL sorgusu
        String sql = "DELETE FROM bookandmovie.bookread WHERE isim = ?";

        // PreparedStatement oluştur
        statement = connection.prepareStatement(sql);
        statement.setString(1, İsim);

        // Sorguyu yürüt
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

}
