package tec.bases;

//Librerias
import picocli.CommandLine;
import tec.bases.cli.MainCommand;

/**
 * Clase principal de la aplicación.
 * Se encarga de iniciar la aplicación y ejecutar el comando principal.
 */
public class App {

    /**
     * Punto de entrada principal de la aplicación.
     * Inicia la aplicación, configura el comando principal y lo ejecuta.
     * Si no se proporcionan argumentos, muestra el uso del comando en la salida estándar.
     * @param args los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new MainCommand());
        cmd.setExecutionStrategy(new CommandLine.RunAll());
        cmd.execute(args);

        if (args.length == 0) {
            cmd.usage(System.out);
        }
    }
}
