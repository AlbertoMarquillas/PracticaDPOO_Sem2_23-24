package Business.Entities;

public class Millora {

    private int valorDeMillora; //valor millora és el multiplicador de la millora, p.ex: millora1 = actual * 2, ha de ser int
    private int costMultiplicador; //cost del valor de millora

    public Millora(int valorDeMillora, int costMultiplicador) {
        this.valorDeMillora = valorDeMillora;
        this.costMultiplicador = costMultiplicador;
    }

    public int getValorDeMillora() {
        return valorDeMillora;
    }

    public void setValorDeMillora(int valorDeMillora) {
        this.valorDeMillora = valorDeMillora;
    }

    public int getCostMultiplicador() {
        return costMultiplicador;
    }

    public void setCostMultiplicador(int costMultiplicador) {
        this.costMultiplicador = costMultiplicador;
    }
}
