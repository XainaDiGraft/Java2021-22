import modelo.beans.Familia;
import modelo.daos.FamiliaListImp;
import modelo.daos.IntFamilia;


/**
 * 01/10/2021
 *
 */
public class TestFamiliaDao {
	public static void main(String[] args) {
		IntFamilia ifam = new FamiliaListImp();
		
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
