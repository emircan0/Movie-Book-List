package controller;

import command.BookListSearchCommand;
import command.BookListingCommand;
import command.Command;
import command.GeneralListener;
import model.BookModel;
import view.BookList;
import view.BookListEdit;
import view.MainFrame;


public class BookListController implements Command{
    
    private MainFrame mainFrame;
    private BookList bookListFrame;
    private BookListEdit bookListEditFrame;
    private BookListingCommand bookListingCommand;
    private BookModel bookModel;
    private BookList bookList;
    
    private int ID;
    private String İsim;
    private String Tur;
    private String Yazar;
    private int SayfaSayisi;
    private String Tarih;
    
    
    public BookListController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
      
    }

    
    
    
    @Override
    public void execute() {    
        initializeListeners();
    }
    
    
    private void initializeListeners() {   
        this.bookListFrame = new BookList();
        mainFrame.DesktopPane.add(bookListFrame);
        bookListFrame.setVisible(true);
        
        bookListingCommand = new BookListingCommand(bookListFrame);
        bookListingCommand.execute(); 
        
        bookListFrame.getTxtBookListSearch().addKeyListener(new BookListSearchCommand(bookListFrame));


        bookListFrame.getBtnBookListEdit().addActionListener(new GeneralListener(new BookListEditController(mainFrame)));
        
    }
    
    
    
    
    
    
}
