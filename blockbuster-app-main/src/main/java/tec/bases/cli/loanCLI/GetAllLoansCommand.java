package tec.bases.cli.loanCLI;

//Librerias
import java.sql.SQLException;
import java.util.List;

import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;
import tec.bases.entity.Loan;

/**
 * Comando para obtener todos los préstamos.
 */
@Command(name = "loanr", description = "Return all loans")
public class GetAllLoansCommand implements Runnable {

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            var loanList = blockbuster.getAllLoans();
            showInfo(loanList);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private void showInfo(List<Loan> _list) {
        System.out.println("LOAN_ID    FILM_ID    CLIENT_ID        DATE        DEVOLUTION_DATE     STATE");
        if (!_list.isEmpty()) {
            for (int indx = 0; indx < _list.size(); indx++) {
                System.out.println(_list.get(indx).toString());
            }
        }
    }
}
