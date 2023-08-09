package controller;

import command.BookListEditAddCommand;
import command.BookListEditDelCommand;
import command.BookReadEditAddCommand;
import command.BookReadEditDelCommand;
import command.Command;
import command.GeneralListener;
import view.BookListEdit;
import view.MainFrame;


public class BookListEditController implements Command{
    
    private MainFrame mainFrame;
    private BookListEdit bookListEditFrame;
    
    
    public BookListEditController(MainFrame mainFrame) {
        this.mainFrame =  mainFrame;
 
        
        
    }

    
    
    @Override
    public void execute() {
        this.bookListEditFrame = new BookListEdit();
        initializeListeners();
    }
    
    private void initializeListeners() {
        mainFrame.DesktopPane.add(bookListEditFrame);
        bookListEditFrame.setVisible(true);
        
        
        
        bookListEditFrame.getBtnAdd().addActionListener(new GeneralListener(new BookListEditAddCommand(bookListEditFrame)));
        bookListEditFrame.getBtnDel().addActionListener(new GeneralListener(new BookListEditDelCommand(bookListEditFrame)));
        
        
    }
    
    
    
    
}
