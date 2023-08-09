package command;

import javax.swing.JOptionPane;
import model.BookModel;
import view.BookListEdit;

public class BookListEditDelCommand implements Command {

    private BookListEdit bookListEditFrame;
    private BookModel bookModel;

    public BookListEditDelCommand(BookListEdit bookListEditFrame) {
        this.bookListEditFrame = bookListEditFrame;
        
    }

    @Override
    public void execute() {
        bookModel = BookListEditDel();
        bookModel.BookDatabaseDel();
       JOptionPane.showMessageDialog(bookListEditFrame, "Silindi", "Uyarı", JOptionPane.INFORMATION_MESSAGE);


    }
    
    private BookModel BookListEditDel(){ 
        String İsim = bookListEditFrame.getTxtBookListİsim().getText();
        return new BookModel(0,İsim,"","",0,"");
        
    }

}
