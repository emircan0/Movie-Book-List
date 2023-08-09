
package command;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.BookModel;
import view.BookListEdit;
import view.MainFrame;


public class BookListEditAddCommand implements Command{
    private BookModel bookModel;
    private BookListEdit bookListEditFrame;
    private MainFrame mainFrame;
    
    
    public BookListEditAddCommand(BookListEdit bookListEditFrame) {
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
       bookModel.BookDatabaseAdd();
       
       
       JOptionPane.showMessageDialog(mainFrame, "Kitap Başarıyla Eklendi.");
        }
        catch (NullPointerException  ex) {
            JOptionPane.showMessageDialog(mainFrame, "Kitap Ekleme Hatası");
        }
    }
    
}
