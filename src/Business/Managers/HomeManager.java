package Business.Managers;

public class HomeManager {
    private final UserManager userManager;

    /**
     * Contructor de la classe de control prncipal
     * @param userManager el manager dels usuaris
     */
    public HomeManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
