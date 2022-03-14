import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        Vetement pull = new Vetement("pull","hiver","rouge","xs",17.50,10);
        Vetement jeans = new Vetement("jeans","hiver","bleu-marine","m",45.00,15);
        Vetement claquettes = new Vetement("claquette","été","blanc","l",12.50,5);
        Vetement tshirt = new Vetement("tshirt","été","noir","m",10.00,10);
        Vetement bottes = new Vetement("bottes","hiver","marron","s",65.00,5);

        VetementDAO dao = new VetementDAO();
        dao.initialisation();

        System.out.println("Avant l'ajout des appart");
        dao.afficherTousLesVetements();

        System.out.println(pull);
        //dao.ajouterVetement(pull);
        dao.ajouterVetement(jeans);
        dao.ajouterVetement(claquettes);
        dao.ajouterVetement(tshirt);
        dao.ajouterVetement(bottes);

        System.out.println("Après l'ajout des appart");
        dao.afficherTousLesVetements();

        List<Vetement> inventoireVetements = dao.retournerTousLesVetements();

        for(Vetement vetement : inventoireVetements)
            System.out.println(vetement);

        dao.cloture();


    }


}