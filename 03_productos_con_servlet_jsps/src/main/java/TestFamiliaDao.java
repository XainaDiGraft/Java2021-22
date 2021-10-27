import modelo.beans.Familia;
import modelo.daos.FamiliaListImpl;
import modelo.daos.IntFamilia;

public class TestFamiliaDao {

	public static void main(String[] args) {
		IntFamilia ifam = new FamiliaListImpl();
		
		Familia fam1 = new Familia(6, "Zapatillas");
		ifam.insertarFamilia(fam1);
		
		ifam.modificarFamilia(new Familia(4,"Zapatos"));
		
		
		for (Familia ele: ifam.findAll())
			System.out.println(ele);
		
		ifam.eliminarFamilia(2);
		
		for (Familia ele: ifam.findAll())
			System.out.println(ele);

	}

}
