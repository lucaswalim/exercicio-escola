package br.com.proway.senior.escola.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.controller.BoletimController;
import br.com.proway.senior.escola.model.Aluno;
import br.com.proway.senior.escola.model.Boletim;
import br.com.proway.senior.escola.model.Materia;

public class ArrayListPersistenceBoletimTest {

	static ArrayListPersistenceBoletim persistence;
	static BoletimController controller;
	static BoletimController controller2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Integer periodo = 202105;
		Materia materia = new Materia();
		Aluno aluno = new Aluno();
		Boletim boletim = new Boletim(aluno, periodo);
		Boletim boletim2 = new Boletim(aluno, 99999);
		persistence = new ArrayListPersistenceBoletim();
		controller = new BoletimController(boletim);
		controller2 = new BoletimController(boletim2);
	}

	@Test
	public void testAdicionaBoletim() {
		persistence.removeAll();
		
		persistence.add(controller.getBoletim());
		persistence.add(controller.getBoletim());
		persistence.add(controller.getBoletim());
		
		assertEquals(3, persistence.dados.size());
		assertNotNull(controller.addBoletim());
		
		
	}
	
	@Test
	public void testZeraBanco() {
		persistence.removeAll();
		
		assertFalse(persistence.dados.size() > 0);
	}
	
	@Test
	public void testRemoveBoletim() {
		persistence.removeAll();
		persistence.add(controller.getBoletim());
		persistence.add(controller.getBoletim());
		
		persistence.remove(0);
		
		assertEquals(1, persistence.dados.size());
	}
	
	@Test
	public void testGet() {
		persistence.removeAll();
		
		persistence.add(controller.getBoletim());
		persistence.add(controller2.getBoletim());
		
		assertEquals(controller2.getBoletim().getPeriodo(), persistence.dados.get(1).getPeriodo());
	}
	
	@Test
	public void testGetAll() {
		persistence.removeAll();
		persistence.add(controller.getBoletim());
		persistence.add(controller.getBoletim());
		persistence.add(controller.getBoletim());
		
		assertEquals(3, persistence.dados.size());
	}

}
