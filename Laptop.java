import java.util.Random;

/**
 * @author Maria Antónia
 * @author Pedro Seco
 */

/**
 * Classe derivada de Computador para gerir as propriedades específicas de Laptops na infraestrutura ICT
 * Implementa o método para calcular o consumo energético específico dos Laptops
 */
public class Laptop extends Computador {

    //region Atributos

    /** Indica se o laptop possui ou não uma GPU */
    private boolean hasGPU;

    //endregion

    //region Construtor

    /**
     * Construtor Default
     * Define dados para a super e para o atributo local
     */
    public Laptop() {
        super("Edge", 16, 64, 256, 1024, 2.0, 3.0);
        this.hasGPU = new Random().nextBoolean();
    }
    //endregion

    //region Métodos

    /** Metodo Overrided
     * @return cálculo do consumo energético específico desta classe derivada
     */
    @Override
    public double consumoEnergetico() {
        if (hasGPU) {
            return 50 * cPU * 1.2;
        } else {
            return 50 * cPU;
        }
    }

    /** Metodo da classe Object Overrided, para output dos dados do Laptop
     * @return string adicional aos dados da super, com os dados GPU do laptop
     */
    @Override
    public String toString() {
        String gpuInfo;
        if (hasGPU) {
            gpuInfo = "Sim";
        } else {
            gpuInfo = "Não";
        }
        return super.toString() + ", GPU: " + gpuInfo;
    }
    //endregion
}

