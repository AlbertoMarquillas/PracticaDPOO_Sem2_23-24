package Business.Entities;

public interface ComptadorInterficie {

    double getQuantitatCoffe();

    void setGameTime(long time);

    long getGameTime();

    void updateQuantitatCoffe(double quantitatCafes, Generator generator1, Generator generator2, Generator generator3);

    void setTaulaContenido(Generator generador1, Generator generador2, Generator generador3);
}
