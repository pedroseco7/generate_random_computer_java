/**
 * @author Maria Antónia
 * @author Pedro Seco
 */

/**
 * Classe derivada de Computador para gerir as propriedades específicas de RaspberryPis na infraestrutura ICT
 * Implementa o método para calcular o consumo energético específico dos Raspberry Pis
 */
public class RaspberryPi extends Computador {

    //region Construtor

    /** Construtor Default
     *  Define dados para a super.
     */
    public RaspberryPi() {
        super("IoT", 2, 8, 16, 128, 1.0, 2.0);
    }

    //endregion

    //region Metodo

    /** Metodo Overrided
     * @return cálculo do consumo energético específico desta classe derivada
     */
    @Override
    public double consumoEnergetico() {
        return 20 * cPU;
    }

    //endregion
}
