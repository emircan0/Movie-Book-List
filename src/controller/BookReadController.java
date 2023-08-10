package controller;

import command.BookListSearchCommand;
import command.BookListingCommand;
import command.BookReadListingCommand;
import command.Command;
import command.GeneralListener;
import command.MouseListenerCommand;
import model.BookModel;
import view.BookList;
import view.BookListEdit;
import view.MainFrame;

public class BookReadController implements Command {

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

    public BookReadController(MainFrame mainFrame) {
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

        bookReadListingCommand = new BookReadListingCommand(bookListFrame);
        bookReadListingCommand.execute();

        bookListFrame.getTxtBookListSearch().addKeyListener(new BookListSearchCommand(bookListFrame));

        bookListFrame.getBtnBookListEdit().addActionListener(new GeneralListener(new BookReadEditController(mainFrame)));
        
        this.bookListFrame = new BookList();
    mainFrame.DesktopPane.add(bookListFrame);
    bookListFrame.setVisible(true);

    bookReadListingCommand = new BookReadListingCommand(bookListFrame);
    bookReadListingCommand.execute();

    bookListFrame.getTxtBookListSearch().addKeyListener(new BookListSearchCommand(bookListFrame));

    bookListFrame.getBtnBookListEdit().addActionListener(new GeneralListener(new BookReadEditController(mainFrame)));
    
    //bookListFrame.tblBookList.addMouseListener(new GeneralListener(new MouseListenerCommand(bookListFrame)));
    
    bookListFrame.btnCopy.addActionListener(new GeneralListener (new MouseListenerCommand(bookListFrame)));
        
        

    }

}
