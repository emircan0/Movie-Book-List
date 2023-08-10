/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.BookModel;
import view.BookList;
import view.BookListEdit;
import view.MainFrame;

import dbHelper.dbHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author emirc
 */
public class MouseListenerCommand implements Command{

    private MainFrame mainFrame;
    private BookList bookListFrame;
    private BookListEdit bookListEditFrame;
    private BookReadListingCommand bookReadListingCommand;
    private BookModel bookModel;
    private BookList bookList;

    private int ID;
    private String İsim;
    private String Tur;
    private String Yazar;
    private int SayfaSayisi;
    private String Tarih;
    
    public MouseListenerCommand(BookList bookListFrame) {
        this.bookListFrame = bookListFrame;
        
    }

   
    @Override
    public void execute() {
        int selectedRow = bookListFrame.getTblBookList().getSelectedRow();
        if (selectedRow != -1) {
            ID = (int) bookListFrame.getModel().getValueAt(selectedRow, 0);
            İsim = (String) bookListFrame.getModel().getValueAt(selectedRow, 1);
            Tur = (String) bookListFrame.getModel().getValueAt(selectedRow, 2);
            Yazar = (String) bookListFrame.getModel().getValueAt(selectedRow, 3);
            SayfaSayisi = (int) bookListFrame.getModel().getValueAt(selectedRow, 4);
            Tarih = (String) bookListFrame.getModel().getValueAt(selectedRow, 5);

            // Veritabanına ekleme işlemini yap
            BookDatabaseAdd();
        }
    }

    public void BookDatabaseAdd() {
        Connection connection = null;
        PreparedStatement statement = null;
        dbHelper dbHelper = new dbHelper();

        try {
            // Veritabanı bağlantısını oluştur
            connection = dbHelper.getConnection();

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
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

