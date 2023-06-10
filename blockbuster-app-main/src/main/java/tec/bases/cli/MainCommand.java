package tec.bases.cli;

//Librerias
import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import tec.bases.cli.loanCLI.*;
import tec.bases.cli.categoryCLI.*;
import tec.bases.cli.filmCLI.*;

/**
 * Comando principal de la aplicación Blockbuster.
 * Permite administrar la información de Blockbuster mediante subcomandos.
 */
@Command(
    name = "BlockbusterAPP",
    subcommands = {
        // Comandos de préstamos
        GetAllLoansCommand.class,
        CreateLoanCommand.class,
        GetLoanByIDCommand.class,
        DeleteLoanCommand.class,

        // Comandos de categorías
        CreateCategoryCommand.class,
        DeleteCategoryCommand.class,
        GetAllCategoriesCommand.class,
        GetCategoryByIDCommand.class,
        UpdateCategoryCommand.class,

        // Comandos de películas
        CreateFilmCommand.class,
        GetAllFilmsCommand.class,
        GetFilmByIDCommand.class,
        DeleteFilmCommand.class,
        UpdateFilmCommand.class,

        // Comando de ayuda
        HelpCommand.class
    },
    description = "Administra la información de Blockbuster"
)
public class MainCommand implements Runnable {

    @Override
    public void run() {
        // Implementación vacía del comando principal
    }
}
