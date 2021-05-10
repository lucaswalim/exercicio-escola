package br.com.proway.senior.escola.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.controller.ProvaController;
import br.com.proway.senior.escola.model.Aluno;
import br.com.proway.senior.escola.model.Materia;
import br.com.proway.senior.escola.model.Prova;

public class ArrayListPersistenceProvaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testRemoveAll() throws Exception{
		ArrayListPersistenceProva persistence = new ArrayListPersistenceProva();
		Aluno aluno = new Aluno();
		Materia materia = new Materia();
		
		Prova prova = new Prova(2021, aluno, materia);
		ProvaController controller = new ProvaController(prova);
		prova.setNota(8d);
		persistence.add(controller.addProva());
		
		System.out.println(persistence.dados.size());
		persistence.removeAll();
		System.out.println(persistence.dados.size());
		
		assertFalse(persistence.dados.size() > 0);
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddProva() throws Exception{
		ArrayListPersistenceProva persistence = new ArrayListPersistenceProva();
		Aluno aluno = new Aluno();
		Materia materia = new Materia();
		
		Prova prova = new Prova(2021, aluno, materia);
		ProvaController controller = new ProvaController(prova);
		prova.setNota(8d);
		
		persistence.add(controller.addProva());
		
		assertEquals(1, persistence.dados.size());
	}

	@Test
	public void testGetInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
