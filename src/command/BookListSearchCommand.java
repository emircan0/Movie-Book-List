package command;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import view.BookList;

public class BookListSearchCommand implements KeyListener  {
    private BookList bookList;
    private DefaultTableModel model;
    

    public BookListSearchCommand(BookList bookList) {
         model = (DefaultTableModel) bookList.tblBookList.getModel();
         this.bookList = bookList;
         
        
    }
    
    
    
    

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String searchKey = bookList.getTxtBookListSearch().getText().trim();

        if (!searchKey.isEmpty()) {
            TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
            bookList.getTblBookList().setRowSorter(tableRowSorter);

            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchKey, 1);
            tableRowSorter.setRowFilter(rowFilter);

            int rowCount = bookList.getTblBookList().getRowCount();
            if (rowCount > 0) {
                bookList.getTblBookList().setRowSelectionInterval(0, 0);
            }
        } else {
            bookList.getTblBookList().setRowSorter(null);
        }
        
    }
    
    
    
}
