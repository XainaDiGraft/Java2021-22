package test;

import modelo.beans.Evento;
import modelo.daos.EventoDaoImplList;
import modelo.daos.IntEventoDao;

public class TestDaoEvento {

	public static void main(String[] args) {
		IntEventoDao edao = new EventoDaoImplList();
		edao.modificarEstadoEvento(2, "cancelado");
		for (Evento ele: edao.findAll())
			System.out.println(ele);

	}

}
