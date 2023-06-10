package tec.bases.cli.filmCLI;

//librerias
import java.sql.SQLException;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import tec.bases.ApplicationContext;

/**
 * Comando para eliminar una película de Blockbuster.
 */
@Command(name = "movd", description = "Delete a film")
public class DeleteFilmCommand implements Runnable {
    
    @CommandLine.Parameters(paramLabel = "<film ID>", description = "film ID")
    private int filmID;

    @Override
    public void run() {
        var blockbuster = new ApplicationContext().getBlockbuster();
        try {
             blockbuster.deleteFilm(Long.valueOf(filmID));
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
