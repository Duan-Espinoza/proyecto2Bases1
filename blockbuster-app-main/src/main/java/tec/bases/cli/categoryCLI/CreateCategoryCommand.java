package tec.bases.cli.categoryCLI;

//librerias
import java.sql.SQLException;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;
import tec.bases.entity.Category;

/**
 * Comando para crear una nueva categoría en Blockbuster.
 */
@Command(name = "catc", description = "Insert a loan")
public class CreateCategoryCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<description>", description = "category description")
    private String descrip;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            blockbuster.saveCategory(new Category(Long.valueOf(1), descrip));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
