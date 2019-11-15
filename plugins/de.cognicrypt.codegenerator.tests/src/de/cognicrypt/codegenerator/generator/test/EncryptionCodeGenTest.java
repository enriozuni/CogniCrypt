package de.cognicrypt.codegenerator.generator.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.logging.Logger;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.cognicrypt.codegenerator.generator.CodeGenerator;
import de.cognicrypt.codegenerator.generator.CrySLBasedCodeGenerator;
import de.cognicrypt.codegenerator.question.Answer;
import de.cognicrypt.codegenerator.question.Page;
import de.cognicrypt.codegenerator.question.Question;
import de.cognicrypt.codegenerator.question.QuestionsJSONReader;
import de.cognicrypt.codegenerator.tasks.Task;
import de.cognicrypt.codegenerator.testutilities.TestUtils;
import de.cognicrypt.codegenerator.wizard.Configuration;
import de.cognicrypt.utils.DeveloperProject;

public class EncryptionCodeGenTest {
	
	Logger log = Logger.getLogger(GenerationTest.class.getName());
	IJavaProject testJavaProject;
	CodeGenerator generatorEnc;
	CodeGenerator generatorSecPassword;
	Task encTask;
	Task secPasswordTask;
	Configuration configEnc;
	Configuration configSecPassword;
	DeveloperProject developerProject;
	static int counter = 0;
	IResource targetFile;
	
	@After
	public void tearDown() throws CoreException {
		TestUtils.deleteProject(this.testJavaProject.getProject());
	}

	@Before
	public void setUp() throws Exception {
		GenerationTest.counter++;
		this.testJavaProject = TestUtils.createJavaProject("TestProject_" + counter);
		targetFile = TestUtils.generateJavaClassInJavaProject(this.testJavaProject, "testPackage", "Test");
		this.encTask = TestUtils.getTask("Encryption");
		this.generatorEnc = new CrySLBasedCodeGenerator(targetFile);
		this.developerProject = this.generatorEnc.getDeveloperProject();
	}
	@Test
	public void testCodeGenerationEncryption() throws CoreException, IOException {
		final ICompilationUnit testClassUnit = TestUtils.getICompilationUnit(this.developerProject, "testPackage", "Test.java");
		TestUtils.openJavaFileInWorkspace(this.developerProject, "testPackage", testClassUnit);

		this.configEnc = TestUtils.createCrySLConfiguration("encryption", testClassUnit.getResource(), generatorEnc, this.developerProject);
		final boolean encCheck = this.generatorEnc.generateCodeTemplates(this.configEnc, this.encTask.getAdditionalResources());
		assertTrue(encCheck);
		
	}
	
	@Test
	public void testCodeGenerationEncryptionHybrid() throws CoreException, IOException {

		final ICompilationUnit testClassUnit = TestUtils.getICompilationUnit(this.developerProject, "testPackage", "Test.java");
		TestUtils.openJavaFileInWorkspace(this.developerProject, "testPackage", testClassUnit);

		this.configEnc = TestUtils.createCrySLConfiguration("encryptionhybrid", testClassUnit.getResource(), generatorEnc, this.developerProject);
		final boolean encCheck = this.generatorEnc.generateCodeTemplates(this.configEnc, this.encTask.getAdditionalResources());
		assertTrue(encCheck);
		
	}
	@Test
	public void testCodeGenerationEncryptionFiles() throws CoreException, IOException {
		final ICompilationUnit testClassUnit = TestUtils.getICompilationUnit(this.developerProject, "testPackage", "Test.java");
		TestUtils.openJavaFileInWorkspace(this.developerProject, "testPackage", testClassUnit);

		this.configEnc = TestUtils.createCrySLConfiguration("encryptionfiles", testClassUnit.getResource(), generatorEnc, this.developerProject);
		final boolean encCheck = this.generatorEnc.generateCodeTemplates(this.configEnc, this.encTask.getAdditionalResources());
		assertTrue(encCheck);
		
	}
	
	@Test
	public void testCodeGenerationEncryptionHybridFiles() throws CoreException, IOException {
		final ICompilationUnit testClassUnit = TestUtils.getICompilationUnit(this.developerProject, "testPackage", "Test.java");
		TestUtils.openJavaFileInWorkspace(this.developerProject, "testPackage", testClassUnit);

		this.configEnc = TestUtils.createCrySLConfiguration("encryptionhybridfiles", testClassUnit.getResource(), generatorEnc, this.developerProject);
		final boolean encCheck = this.generatorEnc.generateCodeTemplates(this.configEnc, this.encTask.getAdditionalResources());
		assertTrue(encCheck);
		
	}
	
	@Test
	public void testCodeGenerationEncryptionHybridStrings() throws CoreException, IOException {
		final ICompilationUnit testClassUnit = TestUtils.getICompilationUnit(this.developerProject, "testPackage", "Test.java");
		TestUtils.openJavaFileInWorkspace(this.developerProject, "testPackage", testClassUnit);

		this.configEnc = TestUtils.createCrySLConfiguration("encryptionhybridstrings", testClassUnit.getResource(), generatorEnc, this.developerProject);
		final boolean encCheck = this.generatorEnc.generateCodeTemplates(this.configEnc, this.encTask.getAdditionalResources());
		assertTrue(encCheck);
		
	}
	
	@Test
	public void testCodeGenerationEncryptionStrings() throws CoreException, IOException {
		final ICompilationUnit testClassUnit = TestUtils.getICompilationUnit(this.developerProject, "testPackage", "Test.java");
		TestUtils.openJavaFileInWorkspace(this.developerProject, "testPackage", testClassUnit);

		this.configEnc = TestUtils.createCrySLConfiguration("encryptionstrings", testClassUnit.getResource(), generatorEnc, this.developerProject);
		final boolean encCheck = this.generatorEnc.generateCodeTemplates(this.configEnc, this.encTask.getAdditionalResources());
		assertTrue(encCheck);
		
	}
	
}