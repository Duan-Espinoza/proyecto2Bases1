package tec.bases.cli.categoryCLI;

//librerias
import java.sql.SQLException;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;

/**
 * Comando para eliminar una categoría en Blockbuster.
 */
@Command(name = "catd", description = "delete a category")
public class DeleteCategoryCommand implements Runnable {

    @CommandLine.Parameters(paramLabel = "<cat ID>", description = "category ID")
    private int catID;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
            blockbuster.deleteCategory(Long.valueOf(catID));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
