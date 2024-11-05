/**
 * @author Maria Antónia
 * @author Pedro Seco
 */

/**
 * Classe derivada de Computador para gerir as propriedades específicas de Servidores na infraestrutura ICT
 * Implementa o método para calcular o consumo energético específico dos Servidores
 */
public class Servidor extends Computador {

    //region Construtor

    /** Construtor Default
     *  Define dados para a super
     */
    public Servidor() {
        super("Cloud", 128, 512, 1024, 16384, 3.0, 4.0);
    }

    //endregion

    //region Metodos

    /** Metodo Overrided
     * @return cálculo do consumo energético específico desta classe derivada
     */
    @Override
    public double consumoEnergetico() {
        return 80 * cPU;
    }

    //endregion
}
