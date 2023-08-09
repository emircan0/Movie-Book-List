package command;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.BookModel;
import view.BookList;

/**
 *
 * @author emirc
 */
public class BookListingCommand implements Command {
    
    private BookList bookListFrame;

    public BookListingCommand(BookList bookListFrame) {
        this.bookListFrame = bookListFrame;
        
    }
    
    

    @Override
    public void execute() {
         // Verileri al
        List<BookModel> books = BookModel.getList();

        // Tabloyu temizle
        DefaultTableModel model = bookListFrame.getModel(); 
        model.setRowCount(0);

        // Yeni verilerle tabloyu doldur
        for (BookModel book : books) {
            Object[] row = {
                book.getID(),
                book.getİsim(),
                book.getTur(),
                book.getYazar(),
                book.getSayfaSayisi(),
                book.getTarih(),

            };
            model.addRow(row);
        }
        
    }
    
}
