package controller;

import command.GeneralListener;
import view.MainFrame;
import controller.BookListController;
import model.BookModel;
import view.BookList;

public class MainController {
    
    private MainFrame mainFrame;
    private BookModel bookModel;
    private BookList bookListFrame;
    

    public MainController() {

        
        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        initializeListeners();
        

    }
    
      private void initializeListeners() {
          

          mainFrame.getBtnBookList().addActionListener(new GeneralListener(new BookListController(mainFrame)));
          mainFrame.getBtnBookRead().addActionListener(new GeneralListener(new BookReadController(mainFrame)));
          
    }

}
