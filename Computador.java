import java.util.Random;

/**
 * @author Maria Antónia
 * @author Pedro Seco
 */

/**
 * Classe para gerir as informações dos computadores, como memória RAM, disco,
 * capacidade de processamento (CPU) e arquitetura de forma aleatória.
 * Fornece métodos para calcular o consumo energético (a ser implementado em subclasses)
 * e para representar em string os atributos do computador.
 */
public class Computador {

    //region Atrinutos

    /** Contador estático para gerar IDs únicos para cada objeto Computador */
    protected static int idCounter = 1; 
    /** ID único do computador */
    protected int id;
    /** Memória RAM em GB */
    protected int memoriaRAM;
    /** Capacidade de armazenamento em disco em GB */
    protected int disco;
    /** Capacidade de processamento da CPU em GHz */
    protected double cPU;
    /** Arquitetura do computador (por exemplo, "x64" ou "ARM") */
    protected String arquitetura;
    /** Nível de uso do computador (por exemplo, "Edge", "Server") */
    protected String nivel;

    //endregion

    //region Construtores

    /** Construtor Default
     */
    public Computador(){

    }

    /**
     * Construtor Completo
     * Inicializa um objeto Computador com valores para ID, nível, arquitetura, RAM, disco e CPU.
     * 
     * @param nivel Nível de uso do computador (por exemplo, "Edge", "Server")
     * @param minRAM Mínimo de memória RAM em GB
     * @param maxRAM Máximo de memória RAM em GB
     * @param minDisco Mínimo de armazenamento em disco em GB
     * @param maxDisco Máximo de armazenamento em disco em GB
     * @param minCPU Capacidade mínima de processamento da CPU em GHz
     * @param maxCPU Capacidade máxima de processamento da CPU em GHz
     */

    public Computador(String nivel, int minRAM, int maxRAM, int minDisco, int maxDisco, double minCPU, double maxCPU){
        this.id = idCounter++;
        this.nivel = nivel;
        this.arquitetura = gerarArquitetura();
        this.memoriaRAM = gerarPotenciaDeDois(minRAM, maxRAM);
        this.disco = gerarPotenciaDeDois(minDisco, maxDisco);
        this.cPU = gerarDouble(minCPU, maxCPU);
    }

    //endregion

    //region Métodos

    /**
     * Gera um valor aleatório que seja uma potência de 2 e que esteja entre um valor mínimo e máximo.
     * 
     * @param min Valor mínimo (inclusivo) da potência de 2
     * @param max Valor máximo (inclusivo) da potência de 2
     * @return Um valor em GB que representa a memória RAM ou espaço de armazenamento (disco)
     */

    public int gerarPotenciaDeDois(int min, int max) {
        Random random = new Random();
        int randomNumber;
        do {
            randomNumber = (int) Math.pow(2, random.nextInt(max + 1 - min));
        } while (randomNumber < min || randomNumber > max);
        return randomNumber;
    }

    /**
     * Gera um valor aleatório do tipo double entre um valor mínimo e máximo.
     * 
     * @param min Valor mínimo do intervalo
     * @param max Valor máximo do intervalo
     * @return Um valor em GHz representando a capacidade de processamento (CPU)
     */
    public double gerarDouble(double min, double max) {
        return min + (max - min) * new Random().nextDouble();
    }

    /**
     * Gerar aleatóriamente uma string entre duas ("x64" ou "ARM")
     * @return arquitetura x64 ou ARM
     */
    public String gerarArquitetura() {
        boolean random = new Random().nextBoolean();
        if (random) {
            return "x64";
        } else {
            return "ARM";
        }
    }
    
    /** Metodo para OVERRIDE nas classes derivadas
     * Calcula o consumo energético do computador em watts
     * @return double, nulo aqui, mas com valores significativos nas derivadas,
     */
    public double consumoEnergetico() {
        return 0; // Cada tipo de computador terá a sua fórmula de consumo específica
    }

    /** Metodo da classe Object Overrided, para output dos dados dos computadores
     * @return string completa com os dados do computador.
     */
    @Override
    public String toString() {
        return "ID: " + id +
                ", RAM: " + memoriaRAM + "GB" +
                ", Disco: " + disco + "GB" +
                ", CPU: " + String.format("%.1f", cPU).replace(",",".") + "GHz" +
                ", Arquitetura: " + arquitetura +
                ", Nível: " + nivel;
    }

    //endregion
}
