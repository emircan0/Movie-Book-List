/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import javax.swing.JOptionPane;
import model.BookModel;
import view.BookListEdit;
import view.MainFrame;


/**
 *
 * @author emirc
 */
public class BookReadEditAddCommand implements Command{
    private BookModel bookModel;
    private BookListEdit bookListEditFrame;
    private MainFrame mainFrame; 
    
    
    public BookReadEditAddCommand(BookListEdit bookListEditFrame) {
        this.bookListEditFrame = bookListEditFrame;
        
    }
    
    
    
    
      @Override
    public void execute() {
        VeritabaninaEkle();
    }

    private void VeritabaninaEkle() {
        try{
        String İsim = bookListEditFrame.getTxtBookListİsim().getText();
        String Tur = bookListEditFrame.getTxtBookListTür().getText();
        String Yazar = bookListEditFrame.getTxtBookListYazar().getText();
        int SayfaSayisi = Integer.parseInt(bookListEditFrame.getTxtBookListSayfa().getText());
        String Tarih = bookListEditFrame.getTxtBookListTarih().getText();
        
       bookModel = new BookModel(0,İsim,Tur,Yazar,SayfaSayisi,Tarih);
       bookModel.BookReadDatabaseAdd();
       
       
       JOptionPane.showMessageDialog(mainFrame, "Kitap Başarıyla Eklendi.");
        }
        catch (NullPointerException  ex) {
            JOptionPane.showMessageDialog(mainFrame, "Kitap Ekleme Hatası");
        }
    }
    
}
