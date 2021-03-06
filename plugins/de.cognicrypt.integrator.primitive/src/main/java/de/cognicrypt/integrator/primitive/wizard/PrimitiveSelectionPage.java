/********************************************************************************
 * Copyright (c) 2015-2019 TU Darmstadt, Paderborn University
 * 

 * http://www.eclipse.org/legal/epl-2.0. SPDX-License-Identifier: EPL-2.0
 ********************************************************************************/

package de.cognicrypt.integrator.primitive.wizard;

import java.util.List;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import de.cognicrypt.core.Constants;
import de.cognicrypt.integrator.primitive.types.Primitive;
import de.cognicrypt.integrator.primitive.types.PrimitiveJSONReader;
import de.cognicrypt.utils.Utils;

public class PrimitiveSelectionPage extends WizardPage {

	private ComboViewer primitiveComboSelection;
	private Composite container;

	/**
	 * Create the wizard.
	 */
	public PrimitiveSelectionPage() {
		super("wizardPage");
		setTitle("Primitive Integration");
		setDescription("Please select the type of the algorithm that you wish to integrate.");
	}

	/**
	 * Create contents of the wizard.
	 *
	 * @param parent
	 */
	@Override
	public void createControl(final Composite parent) {
		this.container = new Composite(parent, SWT.NULL);
		this.container.setBounds(10, 10, 200, 300);
		final GridLayout layout = new GridLayout(3, false);
		this.container.setLayout(layout);
		final List<Primitive> primitives = PrimitiveJSONReader.getPrimitiveTypes(Utils.getResourceFromWithin(Constants.jsonPrimitiveTypesFile));

		setControl(this.container);
		new Label(this.container, SWT.NONE);
		new Label(this.container, SWT.NONE);
		new Label(this.container, SWT.NONE);

		final Label AlgorithmType = new Label(this.container, SWT.NONE);
		AlgorithmType.setText("What kind of algorithm do you want to integrate?       ");
		new Label(this.container, SWT.NONE);

		this.primitiveComboSelection = new ComboViewer(this.container, SWT.DROP_DOWN | SWT.READ_ONLY);
		final Combo combo = this.primitiveComboSelection.getCombo();
		final GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 140;
		combo.setLayoutData(gd_combo);
		this.primitiveComboSelection.setContentProvider(ArrayContentProvider.getInstance());
		this.primitiveComboSelection.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(final Object primitive) {
				if (primitive instanceof Primitive) {
					final Primitive current = (Primitive) primitive;
					return current.getName();
				}
				return super.getText(primitive);
			}
		});
		// add primitives in combo
		this.primitiveComboSelection.setInput(primitives);

		this.primitiveComboSelection.addSelectionChangedListener(event -> {
			final IStructuredSelection selection = (IStructuredSelection) event.getSelection();
			final Primitive selectedPrimitive = (Primitive) selection.getFirstElement();

			PrimitiveSelectionPage.this.primitiveComboSelection.refresh();
			setPageComplete(selectedPrimitive != null);
		});
		this.primitiveComboSelection.setSelection(new StructuredSelection(primitives.get(0)));
	}

	public Primitive getSelectedPrimitive() {
		return (Primitive) ((IStructuredSelection) this.primitiveComboSelection.getSelection()).getFirstElement();
	}

	@Override
	public boolean canFlipToNextPage() {
		return true;
	}

}
