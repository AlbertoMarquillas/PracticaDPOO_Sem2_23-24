package Business.Managers;

import Business.Entities.Millora;

import java.util.ArrayList;

public class MilloraManager {

    private ArrayList<Millora> millores;

    public MilloraManager () {
        millores = new ArrayList<>();
        millores.add(new Millora(2, 10));       //millora pel generador A
        millores.add(new Millora(2, 150));      //millora pel generador B
        millores.add(new Millora(2, 2000));     //millora pel generador C
        millores.add(new Millora(15, 70));      //millora General
    }

    public int getvalorMilloraA(){ return millores.get(0).getValorDeMillora(); }           //valor multiplicador millora A
    public int getcostMultiplicadorA(){ return millores.get(0).getCostMultiplicador(); }   //preu cost multiplicador A

    public int getvalorMilloraB(){ return millores.get(1).getValorDeMillora(); }           //valor multiplicador millora B
    public int getcostMultiplicadorB(){ return millores.get(1).getCostMultiplicador(); }   //preu cost multiplicador B

    public int getvalorMilloraC(){ return millores.get(2).getValorDeMillora(); }           //valor multiplicador millora C
    public int getcostMultiplicadorC(){ return millores.get(2).getCostMultiplicador(); }   //preu cost multiplicador C

    public int getvalorMilloraGeneral(){ return millores.get(3).getValorDeMillora(); }   //valor multiplicador millora General
    public int getcostMultiplicadorGeneral(){ return millores.get(3).getCostMultiplicador(); }   //preu cost multiplicador General


    public void setvalorMilloraA(int valorActualitzatMillora) { millores.get(0).setValorDeMillora(valorActualitzatMillora);}    //per poder actualizar valor A
    public void setvalorMilloraB(int valorActualitzatMillora) { millores.get(1).setValorDeMillora(valorActualitzatMillora);}    //per poder actualizar valor B
    public void setvalorMilloraC(int valorActualitzatMillora) { millores.get(2).setValorDeMillora(valorActualitzatMillora);}    //per poder actualizar valor C
    public void setvalorMilloraGeneral(int valorActualitzatMillora) { millores.get(3).setValorDeMillora(valorActualitzatMillora);}    //per poder actualizar valor General
    public void setcostMultiplicadorA(int costActualitzatMillora) { millores.get(0).setCostMultiplicador(costActualitzatMillora);}    //per poder actualizar cost A
    public void setcostMultiplicadorB(int costActualitzatMillora) { millores.get(1).setCostMultiplicador(costActualitzatMillora);}    //per poder actualizar cost B
    public void setcostMultiplicadorC(int costActualitzatMillora) { millores.get(2).setCostMultiplicador(costActualitzatMillora);}    //per poder actualizar cost C
    public void setcostMultiplicadorGeneral(int costActualitzatMillora) { millores.get(3).setCostMultiplicador(costActualitzatMillora);}    //per poder actualizar cost General
}